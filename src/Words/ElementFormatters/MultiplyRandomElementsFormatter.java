package Words.ElementFormatters;

import Utils.RandomHolder;
import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;

public class MultiplyRandomElementsFormatter extends MultipleElementsFormatter {
	private int bound;

	public MultiplyRandomElementsFormatter(ConditionFilter conditionFilter, int bound) {
		super(conditionFilter, 1);
		this.bound = bound;
	}

	public MultiplyRandomElementsFormatter(int bound) {
		this(new TrueFilter(), bound);
	}

	public MultiplyRandomElementsFormatter(ConditionFilter conditionFilter) {
		this(conditionFilter, 1);
	}

	public MultiplyRandomElementsFormatter() {
		this(new TrueFilter(), 1);
	}

	@Override
	public String getFormattedElement(String elementInput) {
		multiplier = RandomHolder.getInstance().random.nextInt(bound) + 1;
		return super.getFormattedElement(elementInput);
	}
}
