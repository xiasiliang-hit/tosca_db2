package com.example.NodeTypes.propertiesdefinition.winery;

import javax.xml.namespace.QName;
import javax.xml.soap.Detail;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.*;
import javax.xml.ws.soap.*;

/*
@WebFault
(name="DB2Exception",
targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/")
*/
/*public class DB2Exception extends Exception {

    private String errorMsg = "";
    private int errorCode = 0;
    
    protected DB2Exception(int errorCode, String faultStr) {
        super(faultStr);
        
        this.errorCode = errorCode;
        this.errorMsg = faultStr;
    }
}
*/


public class DB2Exception extends SOAPFaultException {

    //private String errorMsg = "";
    //private int errorCode = 0;
    
    protected DB2Exception(SOAPFault sf) {
        super(sf);
        
        System.out.println("db2 exception code: " + sf.getFaultCode());
        System.out.println("db2 exception detail: " + sf.getFaultString());
        
        //this.errorCode = errorCode;
        //this.errorMsg = faultStr;
    }
}