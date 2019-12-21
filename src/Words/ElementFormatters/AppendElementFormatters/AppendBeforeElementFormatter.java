package Words.ElementFormatters.AppendElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class AppendBeforeElementFormatter extends AppendElementFormatter {
	public AppendBeforeElementFormatter(ConditionFilter conditionFilter, String elementAppended) {
		super(conditionFilter, elementAppended);
	}
	
	public AppendBeforeElementFormatter(String elementAppended) {
		super(elementAppended);
	}
	
	public AppendBeforeElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}
	
	public AppendBeforeElementFormatter() {
		super();
	}
	
	@Override
	public String getFormattedElement(String elementInput) {
		return elementAppended + elementInput;
	}
}
