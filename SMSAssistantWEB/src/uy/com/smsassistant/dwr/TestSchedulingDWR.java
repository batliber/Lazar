package uy.com.smsassistant.dwr;

import org.directwebremoting.annotations.RemoteProxy;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import uy.com.smsassistant.schedule.SendSMSSingleJob;

@RemoteProxy
public class TestSchedulingDWR {

	public void testScheduling() {
		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			JobDetail job = 
				JobBuilder.newJob(SendSMSSingleJob.class)
					.storeDurably(true)
					.withIdentity("sendSMSSingleJob", "SMSAssistant")
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
					.withIdentity("tr-" + "SendSMSSingleJob", "SMSAssistant")
					.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
					.build();
			
			scheduler.scheduleJob(job, trigger);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}