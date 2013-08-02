package uy.com.smsassistant.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import uy.com.smsassistant.entities.Schedule;

@Stateless
public class SchedulerBean implements ISchedulerBean{

	@PersistenceContext(unitName = "uy.com.smsassistant.persistenceUnit")
	private EntityManager entityManager;
	
	public void saveSchedule(Schedule schedule) {
		try {
			entityManager.persist(schedule);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}