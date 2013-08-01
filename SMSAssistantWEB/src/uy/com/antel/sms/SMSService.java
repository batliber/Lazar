/**
 * SMSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.antel.sms;

public interface SMSService extends java.rmi.Remote {
    public void sendSMS(java.lang.String number, java.lang.String message) throws java.rmi.RemoteException;
}
