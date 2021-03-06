package com.rameses.gov.etracs.bpls.reports.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

public class BusinessPermitListingReportModel extends AsyncReportController {
    
    @Script('ReportPeriod') 
    def periodUtil; 
    
    @Service('BPPermitReportService')
    def svc;
    
    @Service('BarangayLookupService') 
    def brgySvc;

    @Service('BusinessPermitTypeService')
    def permitTypeSvc;        
    
    String title = "Business Permit Listing";
    String reportpath = 'com/rameses/gov/etracs/bpls/reports/';
    
    def formControl = [ 
        getControlList: { 
            return [
                [type:'combo', caption:'Permit Type', name:'entity.permittype', required:true, preferredSize:'0,20', captionWidth:100, items:'permitTypes',  expression:'#{item.title}'],
                [type:'combo', caption:'Template', name:'entity.template', required:true, items:'templateTypes',  expression:'#{item.title}', preferredSize:'0,20', captionWidth:100], 

                [type:'combo', caption:'Period', name:'entity.period', required:true, items:'periodUtil.types',  expression:'#{item.title}', preferredSize:'100,20', captionWidth:100],
                [type:'integer', caption:'Year', name:'entity.year', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type.matches("yearly|quarterly|monthly")==true }', preferredSize:'100,20', captionWidth:100 ],
                [type:'combo', caption:'Quarter', name:'entity.qtr', required:true, items:'periodUtil.quarters', depends:'entity.period', visibleWhen:'#{ entity.period.type=="quarterly" }', preferredSize:'100,20', captionWidth:100],
                [type:'combo', caption:'Month', name:'entity.month', required:true, items:'periodUtil.months', expression:'#{item.title}', depends:'entity.period', visibleWhen:'#{ entity.period.type=="monthly" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'Date', name:'entity.date', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="daily" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'Start Date', name:'entity.startdate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:100],
                [type:'date', caption:'End Date', name:'entity.enddate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:100],
                
                [type:'combo', caption:'Org. Type', name:'entity.orgtype', items:'orgTypes', expression:'#{item.title}', preferredSize:'0,20', captionWidth:100], 
                [type:'combo', caption:'Barangay', name:'entity.barangay', items:'barangaylist', expression:'#{item.name}', preferredSize:'0,20', captionWidth:100], 
                [type:'combo', caption:'Sort By', name:'entity.sortfield', items:'sortFields', expression:'#{item.name}', preferredSize:'0,20', captionWidth:100] 
            ]; 
        } 
    ] as FormPanelModel; 

    def permitTypes;
    def templateTypes = [
        [objid: 'A', title: 'TEMPLATE - A', name: 'BPPermitListing.jasper'],
        [objid: 'B', title: 'TEMPLATE - B', name: 'BPPermitListing_TemplateB.jasper']
    ];
    def sortFields = [
        [objid: 'owner_name', name: 'Owner Name'],
        [objid: 'tradename', name: 'Trade Name']
    ]; 
    def orgTypes = [ 
        [objid: 'SING', title: 'SINGLE PROPRIETORSHIP'], 
        [objid: 'CORP', title: 'CORPORATION'], 
        [objid: 'COOP', title: 'COOPERATIVE'], 
        [objid: 'ASSO', title: 'ASSOCIATION'], 
        [objid: 'REL',  title: 'RELIGIOUS'], 
        [objid: 'FOUND', title: 'FOUNDATION'], 
        [objid: 'PART', title: 'PARTNERSHIP'], 
        [objid: 'GOV', title: 'GOVERNMENT'], 
        [objid: 'SCH', title: 'SCHOOL'] 
    ]; 


    def initReport() {
        def outcome = super.initReport(); 
        permitTypes = permitTypeSvc.getList(); 
        entity.permittype = (permitTypes? permitTypes[0] : null); 
        entity.period = periodUtil.types[0]; 
        entity.year = new java.sql.Date( System.currentTimeMillis() ).toString().split("-")[0]; 
        entity.template = templateTypes[0];
        entity.sortfield = sortFields[0]; 
        return outcome; 
    }     
    
    boolean isDynamic() {
        return true; 
    } 
    
    String getReportName() { 
        return (reportpath + entity.template.name);  
    } 

    void buildReportData(entity, asyncHandler) { 
        def m = periodUtil.build( entity.period.type, entity ); 
        entity.startdate = m.startdate;
        entity.enddate = m.enddate; 
        svc.getReport( entity, asyncHandler );
    }
    
    void buildResult( data ) { 
        if ( !data.reportdata ) throw new Exception('No available record(s) that matches your criteria.');
    }     
    
    Map getParameters(){
        def m = [
            YEAR: entity.year, ORG_TYPES: [:], 
            ORG_TYPE : ( entity.orgtype ? entity.orgtype.title : '( ALL )'),
            BARANGAY : ( entity.barangay  ? entity.barangay.name : '( ALL )') 
        ]; 
        orgTypes.each{ m.ORG_TYPES.put( it.objid, it.title ) } 
        
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
        m.PERIOD_TITLE = periodtitle; 
        return m; 
    } 
    
    List getBarangaylist() {
        return brgySvc.getList([:]);
    }
}
