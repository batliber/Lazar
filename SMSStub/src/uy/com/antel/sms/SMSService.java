package uy.com.antel.sms;

public class SMSService {

	public SMSService() {
		
	}
	
	public void sendSMS(String number, String message) {
		System.out.println("Sent to: " + number + " - " + message);
	}
}