package uy.com.smsassistant.smsInterface;

import java.util.Map;

public interface ISMSParser {

	public Map<String, String> parseSMS (String message);
}