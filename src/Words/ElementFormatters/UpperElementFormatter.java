package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class UpperElementFormatter extends ElementFormatter {
	public UpperElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}

	public UpperElementFormatter() {
		super();
	}

	@Override
	public String getFormattedElement(String elementInput) {
		return elementInput.toUpperCase();
	}
}
