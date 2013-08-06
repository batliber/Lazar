package uy.com.smsassistant.bean;

import java.util.Collection;

import javax.ejb.Remote;

import uy.com.smsassistant.entities.Schedule;

@Remote
public interface ISchedulerBean {

	public Schedule saveSchedule(Schedule schedule);
	
	public Collection<Schedule> listSchedules();

	public Schedule findScheduleById(Integer id);
}