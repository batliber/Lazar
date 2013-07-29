package uy.com.smsassistant.dwr;

import org.directwebremoting.annotations.RemoteProxy;

import uy.com.smsassistant.smsInterface.SMSSender;

@RemoteProxy
public class TestSMSSenderDWR {
	
	public void testSMSSender() {
		SMSSender sender = new SMSSender();
		
		sender.sendSMS("099455097", "Hola Mundo Lazar!");
	}
}