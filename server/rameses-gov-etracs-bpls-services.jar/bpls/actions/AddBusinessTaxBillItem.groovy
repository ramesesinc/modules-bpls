package bpls.actions;

import bpls.facts.*;
import treasury.actions.*;
import com.rameses.rules.common.*;
import com.rameses.util.*;
import java.util.*;
import com.rameses.osiris3.common.*;

public class AddBusinessTaxBillItem extends AddBillItem {

	public def createBillItemFact( def params, def amt ) {
		def bi = new BusinessBillItem(amount: NumberUtil.round( amt));
		if(params.lob) {
			bi.lob = params.lob;
			bi.assessmenttype = bi.lob.assessmenttype;
		}
		bi.taxfeetype = "TAX";
		return bi;
	}

}

