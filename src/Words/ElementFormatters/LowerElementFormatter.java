package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class LowerElementFormatter extends ElementFormatter {
	public LowerElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}

	public LowerElementFormatter() {
		super();
	}

	@Override
	public String getFormattedElement(String elementInput) {
		return elementInput.toLowerCase();
	}
}
