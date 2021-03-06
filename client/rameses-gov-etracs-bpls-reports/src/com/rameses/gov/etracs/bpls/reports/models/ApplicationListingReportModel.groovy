package com.rameses.gov.etracs.bpls.reports.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.osiris2.reports.*;

public class ApplicationListingReportModel extends AsyncReportController {

    @Script('BusinessReportUtil') 
    def businessReportUtil;
    
    @Script('ReportPeriod') 
    def periodUtil; 

    @Service('BarangayLookupService') 
    def brgySvc;

    @Service('BPApplicationListingReportService')
    def svc; 

    @Service('BusinessPermitTypeService')
    def permitTypeSvc;     

    String title = "Application Listing";
    String reportpath = 'com/rameses/gov/etracs/bpls/reports/'; 
    String reportName = reportpath + 'ApplicationListing.jasper'; 

    @PropertyChangeListener 
    def listeners = [
        'entity.classification': { o-> 
            if ( o ) entity.lob = null; 
        } 
    ];  


    def formControl = [
        getControlList: { 
            return [
                [type:'combo', caption:'Permit Type', name:'entity.permittype', required:true, items:'permitTypes',  expression:'#{item.title}', preferredSize:'0,20', captionWidth:130],
                [type:'combo', caption:'Permit Option', name:'entity.permitoption', required:true, items:'permitOptions',  expression:'#{item.title}', preferredSize:'0,20', captionWidth:130],
            
                [type:'combo', caption:'Period', name:'entity.period', required:true, items:'periodUtil.types',  expression:'#{item.title}', preferredSize:'100,20', captionWidth:130],
                [type:'integer', caption:'Year', name:'entity.year', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type.matches("yearly|quarterly|monthly")==true }', preferredSize:'100,20', captionWidth:130 ],
                [type:'combo', caption:'Quarter', name:'entity.qtr', required:true, items:'periodUtil.quarters', depends:'entity.period', visibleWhen:'#{ entity.period.type=="quarterly" }', preferredSize:'100,20', captionWidth:130],
                [type:'combo', caption:'Month', name:'entity.month', required:true, items:'periodUtil.months', expression:'#{item.title}', depends:'entity.period', visibleWhen:'#{ entity.period.type=="monthly" }', preferredSize:'100,20', captionWidth:130],
                [type:'date', caption:'Date', name:'entity.date', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="daily" }', preferredSize:'100,20', captionWidth:130],
                [type:'date', caption:'Start Date', name:'entity.startdate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:130],
                [type:'date', caption:'End Date', name:'entity.enddate', required:true, depends:'entity.period', visibleWhen:'#{ entity.period.type=="range" }', preferredSize:'100,20', captionWidth:130],

                [type:'checklist', caption:'App Type', name:'entity.apptypes', immediate:true, preferredSize:'0,55', items:'appTypeList', itemExpression:'#{item.title}', selectionMode:'MULTIPLE', itemCount:3, captionWidth:130 ],
                [type:'checklist', caption:'App Status', name:'entity.appstates', immediate:true, preferredSize:'0,55', items:'appStatusList', itemExpression:'#{item.title}', selectionMode:'MULTIPLE', itemCount:3, captionWidth:130 ],
                [type:'checklist', caption:'Assessment Type', name:'entity.assessmenttypes', immediate:true, preferredSize:'0,30', items:'assessmentTypeList', itemExpression:'#{item.title}', selectionMode:'MULTIPLE', itemCount:3, captionWidth:130 ],
                
                [type:'combo', caption:'Barangay', name:'entity.barangay', items:'barangaylist',  expression:'#{item.name}', preferredSize:'0,20', captionWidth:130],
                [type:'combo', caption:'Classification', name:'entity.classification', items:'classificationlist', expression:'#{item.name}', preferredSize:'0,20', captionWidth:130],
                [type:'lookup', caption:'Line of Business', name:'entity.lob', handler:'lookupLOB', expression:'#{item.name}', depends:'entity.classification', preferredSize:'0,20', captionWidth:130],

                [type:'label', caption:'', expression:' ', preferredSize:'0,10', showCaption:false],
                [type:'checkbox', caption:'',  text:'Show Capital', name:'entity.withcapital', immediate:true, preferredSize:'0,20', captionWidth:130 ], 
                [type:'checkbox', caption:'',  text:'Show Gross', name:'entity.withgross', immediate:true, preferredSize:'0,20', captionWidth:130 ] 
            ]; 
        } 
    ] as FormPanelModel; 

    def permitOptions = [
        [objid:'any', title:'Any'],
        [objid:'withpermit', title:'With Permit Only'],
        [objid:'withoutpermit', title:'Without Permit Only'],
    ]; 
    
    def appTypeList = [
        [objid: 'NEW', title:'NEW'],
        [objid: 'RENEW', title:'RENEW'],
        [objid: 'RETIRE', title:'RETIRE'],
        [objid: 'RETIRELOB', title:'RETIRE-LOB'],
        [objid: 'ADDITIONAL', title:'ADDITIONAL'] 
    ];
    def assessmentTypeList = [
        [objid: 'NEW', title:'NEW       '],
        [objid: 'RENEW', title:'RENEW     '],
        [objid: 'RETIRE', title:'RETIRE    ']
    ]; 
    def appStatusList = [
        [objid: 'COMPLETED', title: 'COMPLETED'], 
        [objid: 'RELEASE', title: 'RELEASE'],
        [objid: 'PAYMENT', title: 'PAYMENT'],
        [objid: 'ASSESSMENT', title: 'ASSESSMENT'],
        [objid: 'INFO', title: 'INFO']
    ]; 

    def permitTypes;
    def lobClassifications; 

    def initReport() {
        def outcome = super.initReport(); 
        entity.state_completed = true; 
        entity.period = periodUtil.types[0]; 
        entity.withgross = entity.withcapital = true; 
        entity.apptypes = appTypeList.findAll{ it.objid.matches('NEW|RENEW')}
        entity.appstates = appStatusList.findAll{ it.objid == 'COMPLETED' }    
        entity.assessmenttypes = assessmentTypeList.findAll{ it.objid.matches('NEW|RENEW')} 
        permitTypes = permitTypeSvc.getList(); 
        entity.permittype = (permitTypes? permitTypes[0] : null); 
        entity.permitoption = permitOptions[0];
        lobClassifications = businessReportUtil.getLOBClassifications();    
        return outcome; 
    } 
    
    void buildReportData(entity, asyncHandler) { 
        def m = periodUtil.build( entity.period.type, entity ); 
        entity.startdate = m.startdate;
        entity.enddate = m.enddate; 
        svc.getReport( entity, asyncHandler );
    }
    
    void buildResult( data ) { 
        def opt = entity.permitoption?.objid; 
        if ( opt == 'withpermit' ) {
            data.reportdata = data.reportdata.findAll{( it.dtissued )}
        } else if ( opt == 'withoutpermit' ) { 
            data.reportdata = data.reportdata.findAll{( it.dtissued == null )}
        } 
        
        if ( !data.reportdata ) throw new Exception('No available record(s) that matches your criteria.');
    }    

    Map getParameters(){
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

        def m = [
            PERIOD         : periodtitle, 
            BARANGAYNAME   : ( entity.barangay? entity.barangay.name : '(ALL)' ),
            CLASSIFICATION : ( entity.classification? entity.classification.name : '(ALL)' ),
            LOB            : ( entity.lob? entity.lob.name : '(ALL)' ),
            WITH_CAPITAL   : ( entity.withcapital ? 1 : 0 ),
            WITH_GROSS     : ( entity.withgross ? 1 : 0 ) 
        ]; 
        
        m.APPTYPE = '( ALL )';
        if ( entity.apptypes ) {
            m.APPTYPE = entity.apptypes.collect{ it.objid }.join(', '); 
        } 
        m.ASSESSMENT_TYPE = '( ALL )';
        if ( entity.assessmenttypes ) {
            m.ASSESSMENT_TYPE = entity.assessmenttypes.collect{ it.objid }.join(', '); 
        } 
        m.STATE = '( ALL )';
        if ( entity.appstates ) {
            m.STATE = entity.appstates.collect{ it.objid }.join(', ');
        }         
        m.PERMIT_OPTION = entity.permitoption;
        if ( entity.permitoption?.objid == 'any' ) {
            m.PERMIT_OPTION = null; 
        }
        return m;  
    } 

    List getBarangaylist() {
        return brgySvc.getList([:]);
    }

    List getClassificationlist() {
        return lobClassifications; 
    }

    def getLookupLOB() {
        return Inv.lookupOpener('lob:lookup', [ 
            'query.classification' : entity.classification 
        ]);
    }
}
