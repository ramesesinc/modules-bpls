package bpls.actions;

import com.rameses.rules.common.*;
import bpls.facts.*;

public class AddRequirement implements RuleActionHandler {
	def request;

	public void execute(def params, def drools) {
		def type = params.type;
		def step = params.step;
		def context = params.context;
		if( !request.requirements.find{it.refid == type.key}) {
			request.requirements << [reftype:type.key, title: type.value, step: step, context:context ]; 
		}
	}

}

