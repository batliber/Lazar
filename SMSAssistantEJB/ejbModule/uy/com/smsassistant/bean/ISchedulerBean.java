package uy.com.smsassistant.bean;

import javax.ejb.Remote;

import uy.com.smsassistant.entities.Schedule;

@Remote
public interface ISchedulerBean {

	public void saveSchedule(Schedule schedule);
}