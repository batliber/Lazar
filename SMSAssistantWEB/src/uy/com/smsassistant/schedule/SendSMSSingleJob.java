package uy.com.smsassistant.schedule;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import uy.com.smsassistant.bean.ISchedulerBean;
import uy.com.smsassistant.bean.SchedulerBean;
import uy.com.smsassistant.entities.Schedule;
import uy.com.smsassistant.smsInterface.SMSSender;

public class SendSMSSingleJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			String EARName = "Lazar";
			String beanName = SchedulerBean.class.getSimpleName();
			String remoteInterfaceName = ISchedulerBean.class.getName();
			String lookupName = EARName + "/" + beanName + "/remote-" + remoteInterfaceName;
			
			Context context = new InitialContext();
			ISchedulerBean schedulerBean = (ISchedulerBean) context.lookup(lookupName);
			
			Schedule schedule = schedulerBean.findScheduleById((Integer) arg0.getJobDetail().getJobDataMap().get("scheduleId"));
			
			new SMSSender().sendSMS(schedule.getNumber(), schedule.getMessageToSend());
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}