package Words.ElementFormatters;

import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;

public class MultipleElementsFormatter extends ElementFormatter {
	private int multiplier;

	public MultipleElementsFormatter(ConditionFilter conditionFilter, int multiplier) {
		super(conditionFilter);
		this.multiplier = multiplier;
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