package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class ReverseElementFormatter extends ElementFormatter {
	public ReverseElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}

	public ReverseElementFormatter() {
		super();
	}

	@Override
	public String getFormattedElement(String elementInput) {
		return new StringBuilder(elementInput).reverse().toString();
	}
}
