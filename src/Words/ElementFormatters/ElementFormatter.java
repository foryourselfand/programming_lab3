package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;

public abstract class ElementFormatter {
	private ConditionFilter conditionFilter;

	public ElementFormatter(ConditionFilter conditionFilter) {
		this.conditionFilter = conditionFilter;
	}

	public ElementFormatter() {
		this(new TrueFilter());
	}

	public boolean getCondition(int index) {
		return conditionFilter.condition(index);
	}

	public abstract String getFormattedElement(String elementInput);
}
