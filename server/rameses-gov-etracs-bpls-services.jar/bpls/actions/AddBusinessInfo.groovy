package bpls.actions;

import com.rameses.rules.common.*;
import bpls.facts.*;
import enterprise.actions.*;

public class AddBusinessInfo extends AddInfo {

	//overridable. Key normally is the name
	public def createKeyFinder( def infoName, def params ) {
		return { o-> 
			def lobid = params.lob?.objid;
			if( lobid ) {
				return ( o.lob?.objid == lobid && o.name == infoName  );
			}
			else {
				return (o.name == infoName);
			}
		};		
	}

	public void execute(def params, def drools) {
		if(!params.attribute) {
			throw new Exception("Please specify an attribute");	
		}
		params.name = params.attribute;
		if(params.defaultvalue) {
			params.value =  params.defaultvalue;
		}	
		super.execute( params, drools );
	}

}

