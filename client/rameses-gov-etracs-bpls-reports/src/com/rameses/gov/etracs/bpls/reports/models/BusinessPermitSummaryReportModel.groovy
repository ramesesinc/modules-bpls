package com.rameses.gov.etracs.bpls.reports.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

public class BusinessPermitSummaryReportController extends AsyncReportController 
{
    @Service('BPPermitSummaryReportService')
    def svc;
    
    @Service('BusinessPermitTypeService')
    def permitTypeSvc;        

    String title = "Summary of Business Permit";
    String reportpath = 'com/rameses/gov/etracs/bpls/reports/';
    
    def formControl = [ 
        getControlList: { 
            return [
                [type:'combo', caption:'Permit Type', name:'entity.permittype', required:true, items:'permitTypes',  expression:'#{item.title}', preferredSize:'0,20', captionWidth:100],
                [type:'combo', caption:'Template', name:'entity.template', required:true, items:'templateTypes',  expression:'#{item.title}', preferredSize:'0,20', captionWidth:100], 
                [type:'integer', caption:'Year', name:'entity.year', required:true, preferredSize:'100,20', captionWidth:100 ] 
            ];
        } 
    ] as FormPanelModel; 

    def permitTypes;
    def templateTypes = [
        [objid: 'A', title: 'TEMPLATE - A'],
        [objid: 'B', title: 'TEMPLATE - B']
    ];
    
    def initReport() {
        def outcome = super.initReport(); 
        permitTypes = permitTypeSvc.getList(); 
        entity.permittype = (permitTypes? permitTypes[0] : null); 
        entity.year = new java.sql.Date( System.currentTimeMillis() ).toString().split("-")[0]; 
        entity.template = templateTypes[0];
        return outcome; 
    } 
    
    String getReportName() {
        if ( entity.template?.objid == 'B' ) {
            return reportpath + 'BusinessPermitSummary_TemplateB.jasper';             
        } else {
            return reportpath + 'BusinessPermitSummary.jasper';
        } 
    } 

    boolean isDynamic() {
        return true; 
    } 
    
    void buildReportData(entity, asyncHandler) { 
        svc.getReport( entity, asyncHandler );
    }
    
    void buildResult( data ) { 
        if ( !data.reportdata ) throw new Exception('No available record(s) that matches your criteria.');
    } 
    
    Map getParameters(){
        def m = [:];  
        return m; 
    } 
}