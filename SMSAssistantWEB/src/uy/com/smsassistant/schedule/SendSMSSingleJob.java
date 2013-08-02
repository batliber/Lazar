package uy.com.smsassistant.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import uy.com.smsassistant.smsInterface.SMSSender;

public class SendSMSSingleJob implements Job {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		new SMSSender().sendSMS("099455097", "Quartz SMS!");
	}
}