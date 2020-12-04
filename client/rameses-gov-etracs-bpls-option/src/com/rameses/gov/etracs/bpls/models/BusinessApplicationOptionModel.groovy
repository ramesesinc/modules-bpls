package com.rameses.gov.etracs.bpls.models;

import com.rameses.rcp.annotations.*; 

class BusinessApplicationOptionModel {

    @Service('PersistenceService')
    def persistenceSvc; 
    
    @Caller 
    def caller;
    
    def schema_name = 'business_application_option'; 
    
    def appid; 
    def data; 
    
    public void open() {
        data = [:]; 
        appid = caller?.entity?.objid; 
        loadOpts(); 
    }
    
    void loadOpts() {
        def opts = persistenceSvc.read([ _schemaname: schema_name, objid: appid ]); 
        if ( opts == null ) opts = [:]; 
        
        data.clear(); 
        data.putAll( opts ); 
    }
 
    public def doOk() { 
        data._schemaname = schema_name; 
        data.objid = appid; 
        persistenceSvc.update( data ); 
        return '_close';
    }
    
    public def doCancel() {
        return '_close'; 
    }
}
