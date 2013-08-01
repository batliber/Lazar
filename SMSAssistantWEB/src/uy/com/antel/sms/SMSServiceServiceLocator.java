/**
 * SMSServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package uy.com.antel.sms;

public class SMSServiceServiceLocator extends org.apache.axis.client.Service implements uy.com.antel.sms.SMSServiceService {

    public SMSServiceServiceLocator() {
    }


    public SMSServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SMSServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SMSService
    private java.lang.String SMSService_address = "http://localhost:8080/SMSStub/services/SMSService";

    public java.lang.String getSMSServiceAddress() {
        return SMSService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SMSServiceWSDDServiceName = "SMSService";

    public java.lang.String getSMSServiceWSDDServiceName() {
        return SMSServiceWSDDServiceName;
    }

    public void setSMSServiceWSDDServiceName(java.lang.String name) {
        SMSServiceWSDDServiceName = name;
    }

    public uy.com.antel.sms.SMSService getSMSService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SMSService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSMSService(endpoint);
    }

    public uy.com.antel.sms.SMSService getSMSService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            uy.com.antel.sms.SMSServiceSoapBindingStub _stub = new uy.com.antel.sms.SMSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getSMSServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSMSServiceEndpointAddress(java.lang.String address) {
        SMSService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (uy.com.antel.sms.SMSService.class.isAssignableFrom(serviceEndpointInterface)) {
                uy.com.antel.sms.SMSServiceSoapBindingStub _stub = new uy.com.antel.sms.SMSServiceSoapBindingStub(new java.net.URL(SMSService_address), this);
                _stub.setPortName(getSMSServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SMSService".equals(inputPortName)) {
            return getSMSService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://sms.antel.com.uy", "SMSServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://sms.antel.com.uy", "SMSService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SMSService".equals(portName)) {
            setSMSServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
