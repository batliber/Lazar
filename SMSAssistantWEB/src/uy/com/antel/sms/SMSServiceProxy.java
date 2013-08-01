package uy.com.antel.sms;

public class SMSServiceProxy implements uy.com.antel.sms.SMSService {
  private String _endpoint = null;
  private uy.com.antel.sms.SMSService sMSService = null;
  
  public SMSServiceProxy() {
    _initSMSServiceProxy();
  }
  
  public SMSServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSMSServiceProxy();
  }
  
  private void _initSMSServiceProxy() {
    try {
      sMSService = (new uy.com.antel.sms.SMSServiceServiceLocator()).getSMSService();
      if (sMSService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sMSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sMSService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sMSService != null)
      ((javax.xml.rpc.Stub)sMSService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public uy.com.antel.sms.SMSService getSMSService() {
    if (sMSService == null)
      _initSMSServiceProxy();
    return sMSService;
  }
  
  public void sendSMS(java.lang.String number, java.lang.String message) throws java.rmi.RemoteException{
    if (sMSService == null)
      _initSMSServiceProxy();
    sMSService.sendSMS(number, message);
  }
  
  
}