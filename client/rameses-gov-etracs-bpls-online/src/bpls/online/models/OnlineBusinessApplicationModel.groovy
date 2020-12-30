package bpls.online.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.CrudFormModel;

class OnlineBusinessApplicationModel extends CrudFormModel {

    @Service('OnlineBusinessApplicationService') 
    def appSvc;
    
    def selectedRequirement;
    
    public void afterOpen(){
        if ( entity.infos ) {
            def malecount = toInteger( entity.infos.find{( it.name == 'NUM_EMPLOYEE_MALE')}?.value );
            def femalecount = toInteger( entity.infos.find{( it.name == 'NUM_EMPLOYEE_FEMALE')}?.value );
            def totalcount = (malecount ? malecount : 0) + (femalecount ? femalecount : 0); 
            entity.infos << [ 
                name: 'NUM_EMPLOYEE', caption:'NO. OF EMPLOYEES', 
                datatype: 'integer', value: totalcount 
            ]; 
        }
        
        if ( entity.requirements ) {
            entity.requirements.each{
                it.hasattachment = ( it.attachment?.location ? true : false );
            }
        }
        
        if ( binding ) {
            binding.notifyDepends('formActions'); 
        }
    }
    
    def toInteger( value ) {
        try {
            if ( value instanceof Number ) {
                return value; 
            }
            return value.toInteger(); 
        } catch(Throwable t) {
            return null; 
        }
    }
        
    def lobListHandler = [
        fetchList: {
            entity.lobs; 
        }
    ] as DataListModel;

    def infoListHandler = [
        fetchList: {
            entity.infos; 
        }
    ] as DataListModel;

    def requirementListHandler = [
        fetchList: {
            entity.requirements; 
        }
    ] as DataListModel;

    
    boolean isWithAttachment() {
        return (selectedRequirement?.attachment?.location ? true : false); 
    }
  
    void downloadAttachment() {
        if ( !isWithAttachment() ) return; 
    }
    
    void viewAttachment() {
        if ( !isWithAttachment() ) return; 
        
    }
    
    void approve() {
        if ( MsgBox.confirm('You are about to submit this application for processing.\nDo you want to continue?')) {
            def res = appSvc.approve([ objid: entity.objid ]); 
            if ( res?.state ) entity.state = res.state; 
        }
    }
} 