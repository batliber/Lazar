/**
 * SMSServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.antel.sms;

public interface SMSServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSMSServiceAddress();

    public uy.com.antel.sms.SMSService getSMSService() throws javax.xml.rpc.ServiceException;

    public uy.com.antel.sms.SMSService getSMSService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
