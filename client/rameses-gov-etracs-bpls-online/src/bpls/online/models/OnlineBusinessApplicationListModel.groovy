package bpls.online.models;

import com.rameses.rcp.annotations.*;
import com.rameses.rcp.common.*;
import com.rameses.osiris2.common.*;
import com.rameses.osiris2.client.*;
import com.rameses.seti2.models.CrudListModel;

class OnlineBusinessApplicationListModel extends CrudListModel {

    def coldefs = [
        [name: 'bin', caption: 'BIN'],
        [name: 'tradename', caption: 'TradeName'],
        [name: 'businessname', caption: 'BusinessName'],
        [name: 'address.text', caption: 'BusinessAddress'],
        [name: 'owner.name', caption: 'OwnerName'],
        [name: 'appyear', caption: 'AppYear', width: 80, maxWidth: 80, type: 'integer'],
        [name: 'appdate', caption: 'AppDate', width: 80, maxWidth: 80, type: 'date'],
        [name: 'apptype', caption: 'AppType', width: 80, maxWidth: 80],
        [name: 'controlno', caption: 'ControlNo']
    ]; 
    
    public void initColumn( c ) { 
        
        def col = coldefs.find{( it.name == c.name )}
        if ( col ) c.putAll( col ); 
    }  
    
} 