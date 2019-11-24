package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class DefaultElementFormatter extends ElementFormatter {
	public DefaultElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}

	public DefaultElementFormatter() {
		super();
	}

	@Override
	public String getFormattedElement(String elementInput) {
		return elementInput;
	}
}
