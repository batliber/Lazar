package uy.com.smsassistant.dwr;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.smsassistant.bean.ISchedulerBean;
import uy.com.smsassistant.bean.SchedulerBean;
import uy.com.smsassistant.entities.Schedule;
import uy.com.smsassistant.entities.ScheduleData;
import uy.com.smsassistant.smsInterface.SMSParser;

@RemoteProxy
public class SchedulerDWR {

	public void addScheduledEvent(String number, String message) {
		try {
			SMSParser sMSParser = new SMSParser();
			
			ScheduleData scheduleData = sMSParser.parseSMS(message);
			
			String EARName = "Lazar";
			String beanName = SchedulerBean.class.getSimpleName();
			String remoteInterfaceName = ISchedulerBean.class.getName();
			String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
			
			Context context = new InitialContext();
			ISchedulerBean schedulerBean = (ISchedulerBean) context.lookup(lookupName);
			
			Schedule schedule = new Schedule();
			schedule.setBoxId(scheduleData.getBoxId());
			schedule.setMessageToSend(scheduleData.getMessageToSend());
			schedule.setNumber(scheduleData.getNumber());
			schedule.setReceivedMessage(scheduleData.getReceivedMessage());
			
			schedulerBean.saveSchedule(schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//			
//			JobDetail job = 
//				JobBuilder.newJob(SendSMSSingleJob.class)
//					.storeDurably(true)
//					.withIdentity("sendSMSSingleJob", "SMSAssistant")
//					.build();
//
//			String seconds = "0";
//			String minutes = "0/5";
//			String hours = "*";
//			String dayOfMonth = "*";
//			String month = "*";
//			String dayOfWeek = "?";
//			String year = "*";
//			
//			String cronExpression = 
//				seconds + " " +  minutes  + " " +  hours  + " " +  dayOfMonth + " " +  month + " " +  dayOfWeek + " " +  year;
//			
//			CronTrigger trigger = 
//				TriggerBuilder.newTrigger()
//					.withIdentity("tr-" + "SendSMSSingleJob", "SMSAssistant")
//					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
//					.build();
//			
//			scheduler.scheduleJob(job, trigger);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}