package uy.com.smsassistant.smsInterface;

import uy.com.smsassistant.entities.ScheduleData;

public class SMSParser {

	public ScheduleData parseSMS(String message) {
		ScheduleData result = new ScheduleData();
		result.setBoxId("1234");
		result.setMessageToSend("A tomar el medicamento!");
		result.setNumber("099455097");
		result.setReceivedMessage("1234 8 12:00");
		
		return result;
	}
}