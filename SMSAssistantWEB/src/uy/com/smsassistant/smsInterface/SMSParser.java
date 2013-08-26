package uy.com.smsassistant.smsInterface;

import java.util.HashMap;
import java.util.Map;

public class SMSParser implements ISMSParser {

	public Map<String, String> parseSMS(String message) {
		Map<String, String> result = new HashMap<String, String>();
		
		result.put("boxId", "1234");
		result.put("messageToSend", "A tomar el medicamento!");
		result.put("receivedMessage", message);
		
		return result;
	}
}