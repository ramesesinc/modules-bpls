package com.rameses.gov.etracs.bpls.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.reports.*;

class BusinessClosureCertificateModel extends ReportController {
    
    @Service('BusinessClosureCertificateService') 
    def svc; 

    String title = "Business Closure Certificate";
    String reportPath = 'com/rameses/gov/etracs/bpls/reports/application'; 
    
    def info; 
    
    def initReport() { 
        info = svc.getInfo([ businessid: entity.business?.objid ]); 
        if ( !info?.objid ) throw new Exception('Business record not found'); 
        if ( info.state.toString() != 'RETIRED' ) throw new Exception('Business status must be RETIRED'); 
        
        if ( !info.closure?.objid ) {
            info = [:]; 
            return 'default'; 
        }
        return preview(); 
    }
    
    def doSubmit() {
        info.businessid = entity.business?.objid; 
        svc.create( info ); 
        return preview();
    }
    
    def doCancel() {
        return '_close'; 
    }
    
    def doClose() {
        return '_close';
    }
    
    String getReportName() {
        return reportPath + '/business_closure_certificate.jasper'; 
    } 
    
    def getReportData() {
        return svc.getReport([ businessid: entity.business?.objid ]); 
    }     
}