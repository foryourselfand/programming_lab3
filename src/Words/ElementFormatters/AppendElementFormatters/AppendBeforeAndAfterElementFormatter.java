package Words.ElementFormatters.AppendElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class AppendBeforeAndAfterElementFormatter extends AppendElementFormatter {
	public AppendBeforeAndAfterElementFormatter(ConditionFilter conditionFilter, String elementAppended) {
		super(conditionFilter, elementAppended);
	}
	
	public AppendBeforeAndAfterElementFormatter(String elementAppended) {
		super(elementAppended);
	}
	
	public AppendBeforeAndAfterElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}
	
	public AppendBeforeAndAfterElementFormatter() {
		super();
	}
	
	@Override
	public String getFormattedElement(String elementInput) {
		return elementAppended + elementInput + elementAppended;
	}
}
