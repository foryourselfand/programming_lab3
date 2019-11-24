package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;

public class MirrorElementFormatter extends ElementFormatter {
	public MirrorElementFormatter(ConditionFilter conditionFilter) {
		super(conditionFilter);
	}

	public MirrorElementFormatter() {
		super();
	}

	@Override
	public String getFormattedElement(String elementInput) {
		return elementInput + new StringBuilder(elementInput).reverse().toString();
	}
}
