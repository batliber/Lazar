package uy.com.smsassistant.bean;

import java.util.Collection;
import java.util.LinkedList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import uy.com.smsassistant.entities.Schedule;

@Stateless
public class SchedulerBean implements ISchedulerBean{

	@PersistenceContext(unitName = "uy.com.smsassistant.persistenceUnit")
	private EntityManager entityManager;
	
	public Schedule saveSchedule(Schedule schedule) {
		Schedule result = null;
		
		try {
			entityManager.persist(schedule);
			
			result = schedule;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Collection<Schedule> listSchedules() {
		Collection<Schedule> result = new LinkedList<Schedule>();
		
		try {
			Query query = entityManager.createQuery("SELECT s FROM Schedule s");
			
			for (Object object : query.getResultList()) {
				result.add((Schedule) object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public Schedule findScheduleById(Integer id) {
		Schedule result = null;
		
		try {
			result = entityManager.find(Schedule.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


	public void clearSchedules() {
		try {
			Query query = entityManager.createQuery("DELETE FROM Schedule");
			
			query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}