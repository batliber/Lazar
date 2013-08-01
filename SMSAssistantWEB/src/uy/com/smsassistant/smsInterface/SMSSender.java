package uy.com.smsassistant.smsInterface;

import java.rmi.RemoteException;

import uy.com.antel.sms.SMSService;
import uy.com.antel.sms.SMSServiceProxy;

public class SMSSender {

	public SMSSender() {
		
	}
	
	public void sendSMS(String number, String message) {
		try {
			SMSService smsService = new SMSServiceProxy();
			
			smsService.sendSMS(number, message);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}