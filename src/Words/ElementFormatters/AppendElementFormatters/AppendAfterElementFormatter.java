package Words.ElementFormatters.AppendElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class AppendAfterElementFormatter extends AppendElementFormatter {
	public AppendAfterElementFormatter(ConditionFilter conditionFilter, String elementAppended) {
		super(conditionFilter, elementAppended);
	}
	
	public AppendAfterElementFormatter(String elementAppended) {
		super(elementAppended);
	}
	
	public AppendAfterElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}
	
	public AppendAfterElementFormatter() {
		super();
	}
	
	@Override
	public String getFormattedElement(String elementInput) {
		return elementInput + elementAppended;
	}
}
