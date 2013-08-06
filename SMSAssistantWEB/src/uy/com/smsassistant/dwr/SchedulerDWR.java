package uy.com.smsassistant.dwr;

import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.directwebremoting.annotations.RemoteProxy;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import uy.com.smsassistant.bean.ISchedulerBean;
import uy.com.smsassistant.bean.SchedulerBean;
import uy.com.smsassistant.entities.Schedule;
import uy.com.smsassistant.entities.ScheduleData;
import uy.com.smsassistant.schedule.SendSMSSingleJob;
import uy.com.smsassistant.smsInterface.SMSParser;

@RemoteProxy
public class SchedulerDWR {

	public void addScheduledEvent(String number, String message) {
		try {
			// Parseo del SMS
			SMSParser sMSParser = new SMSParser();
			
			ScheduleData scheduleData = sMSParser.parseSMS(message);
			scheduleData.setNumber(number);
			
			// Lookup del EJB
			String EARName = "Lazar";
			String beanName = SchedulerBean.class.getSimpleName();
			String remoteInterfaceName = ISchedulerBean.class.getName();
			String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
			
			Context context = new InitialContext();
			ISchedulerBean schedulerBean = (ISchedulerBean) context.lookup(lookupName);
			
			// Creación de la meta-data para las notificaciones
			Schedule schedule = new Schedule();
			schedule.setBoxId(scheduleData.getBoxId());
			schedule.setMessageToSend(scheduleData.getMessageToSend());
			schedule.setNumber(scheduleData.getNumber());
			schedule.setReceivedMessage(scheduleData.getReceivedMessage());
			
			schedule = schedulerBean.saveSchedule(schedule);
			
			// Agendado en Quartz de las notificaciones
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

			JobDetail job = 
				JobBuilder.newJob(SendSMSSingleJob.class)
					.storeDurably(true)
					.withIdentity("sendSMSSingleJob", "SMSAssistant")
					.usingJobData("scheduleId", schedule.getId())
					.build();

			String seconds = "0";
			String minutes = "0/5";
			String hours = "*";
			String dayOfMonth = "*";
			String month = "*";
			String dayOfWeek = "?";
			String year = "*";
			
			String cronExpression = 
				seconds + " " +  minutes  + " " +  hours  + " " +  dayOfMonth + " " +  month + " " +  dayOfWeek + " " +  year;
			
			CronTrigger trigger = 
				TriggerBuilder.newTrigger()
					.withIdentity("trggr-" + "SendSMSSingleJob", "SMSAssistant")
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.build();
			
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Collection<ScheduleData> listScheduledEvents() {
		Collection<ScheduleData> result = new LinkedList<ScheduleData>();
		
		try {
			String EARName = "Lazar";
			String beanName = SchedulerBean.class.getSimpleName();
			String remoteInterfaceName = ISchedulerBean.class.getName();
			String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
			
			Context context = new InitialContext();
			ISchedulerBean schedulerBean = (ISchedulerBean) context.lookup(lookupName);
			
			for (Schedule schedule : schedulerBean.listSchedules()) {
				ScheduleData scheduleData = new ScheduleData();
				scheduleData.setBoxId(schedule.getBoxId());
				scheduleData.setId(schedule.getId());
				scheduleData.setMessageToSend(schedule.getMessageToSend());
				scheduleData.setNumber(schedule.getNumber());
				scheduleData.setReceivedMessage(schedule.getReceivedMessage());
				
				result.add(scheduleData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}