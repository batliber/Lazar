package uy.com.smsassistant.smsInterface;

import uy.com.smsassistant.entities.ScheduleData;

public class SMSParser {

	public ScheduleData parseSMS(String message) {
		ScheduleData result = new ScheduleData();
		result.setBoxId("1234");
		result.setMessageToSend("A tomar el medicamento!");
		result.setReceivedMessage(message);
		
		return result;
	}
}