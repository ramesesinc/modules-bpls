package com.rameses.gov.etracs.bpls.reports.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

public class BPQtrPaidBusinessListingReportModel extends AsyncReportController {

    @Service('BPQuarterlypPaidReportService')
    def svc;

    @Service('BusinessPermitTypeService')
    def permitTypeSvc;    
    
    @Script('ReportPeriod') 
    def periodUtil; 
    
    String title = "Quarterly Paid Business Listing";
    String reportpath = 'com/rameses/gov/etracs/bpls/reports/';
    String reportName = reportpath + 'QtrlyPaidBusinessListing.jasper' ;
        
    def formControl = [
        getControlList: { 
            return [
                [type:'combo', caption:'Period', name:'entity.period', required:true, items:'periodUtil.types',  expression:'#{item.title}', preferredSize:'100,20', captionWidth:100],
                [type:'integer', caption:'Year', name:'entity.year', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type.matches("yearly|quarterly|monthly")==true }', preferredSize:'100,20', captionWidth:100 ],
                [type:'combo', caption:'Quarter', name:'entity.qtr', required:true, items:'periodUtil.quarters', depends:'entity.period', visibleWhen:'#{ entity.period.type=="quarterly" }', preferredSize:'100,20', captionWidth:100],
                [type:'combo', caption:'Month', name:'entity.month', required:true, items:'periodUtil.months', expression:'#{item.title}', depends:'entity.period', visibleWhen:'#{ entity.period.type=="monthly" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'Date', name:'entity.date', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="daily" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'Start Date', name:'entity.startdate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'End Date', name:'entity.enddate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:100],

                [type:'checklist', caption:'Status', name:'entity.appstates', immediate:true, preferredSize:'0,25', items:'appStatusList', itemExpression:'#{item.title}', selectionMode:'MULTIPLE', itemCount:3, captionWidth:100 ],
                [type:'combo', caption:'Permit Type', name:'entity.permittype', required:true, preferredSize:'0,20', captionWidth:100, items:'permitTypes',  expression:'#{item.title}']
            ]; 
        } 
    ] as FormPanelModel; 

    def appStatusList = [
        [objid: 'PAYMENT', title: 'FOR-PAYMENT'],
        [objid: 'RELEASE', title: 'FOR-RELEASE'],
        [objid: 'COMPLETED', title: 'COMPLETED'] 
    ];     

    def permitTypes; 
    def params = [:];     

    def initReport() {
        def outcome = super.initReport(); 
        permitTypes = permitTypeSvc.getList(); 
        entity.permittype = (permitTypes? permitTypes[0] : null); 
        entity.period = periodUtil.types[0]; 
        entity.year = new java.sql.Date( System.currentTimeMillis() ).toString().split("-")[0]; 
        entity.appstates = appStatusList.findAll{ it.objid == 'COMPLETED' } 
        return outcome; 
    } 
    
    void buildReportData(entity, asyncHandler) { 
        if ( !entity.appstates ) throw new Exception('Please specify at least 1 application status'); 
        
        def m = periodUtil.build( entity.period.type, entity ); 
        entity.startdate = m.startdate;
        entity.enddate = m.enddate; 
        svc.getReport( entity, asyncHandler );
    }
    
    void buildResult( data ) { 
        if ( !data.reportdata ) throw new Exception('No available record(s) that matches your criteria.');
    }     

    Map getParameters() { 
        def periodtitle = null; 
        if ( entity.period.type == 'yearly' ) {
            periodtitle = periodUtil.getPeriodTitle([ year: entity.year ]);
        } else if ( entity.period.type == 'quarterly' ) { 
            periodtitle = periodUtil.getPeriodTitle([ year: entity.year, qtr: entity.qtr ]);
        } else if ( entity.period.type == 'monthly' ) {
            periodtitle = periodUtil.getPeriodTitle([ year: entity.year, month: entity.month.index ]);
        } else if ( entity.period.type == 'daily' ) {
            periodtitle = periodUtil.getPeriodTitle([ date: entity.date ]);
        } else if ( entity.period.type == 'range' ) {
            periodtitle = periodUtil.getPeriodTitle([ startdate: entity.startdate, enddate: entity.enddate ]);
        } 

        def appstates = entity.appstates.collect{( it.objid )}  
        params.STATE  = appstates.join(', ');            
        params.PERIOD = periodtitle; 
        return params; 
    }
}
