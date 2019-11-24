package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;

public class MultipleElementsFormatter extends ElementFormatter {
	protected int multiplier;

	public MultipleElementsFormatter(ConditionFilter conditionFilter, int multiplier) {
		super(conditionFilter);
		this.multiplier = multiplier;
	}

	public MultipleElementsFormatter(int multiplier) {
		this(new TrueFilter(), multiplier);
	}

	public MultipleElementsFormatter(ConditionFilter conditionFilter) {
		this(conditionFilter, 1);
	}

	public MultipleElementsFormatter() {
		this(new TrueFilter(), 1);
	}

	@Override
	public String getFormattedElement(String elementInput) {
		if (multiplier == 1)
			return elementInput;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < multiplier; i++)
			stringBuilder.append(elementInput);
		return stringBuilder.toString();
	}
}
