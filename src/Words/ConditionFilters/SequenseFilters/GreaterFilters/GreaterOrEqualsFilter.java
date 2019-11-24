package Words.ConditionFilters.SequenseFilters.GreaterFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public class GreaterOrEqualsFilter extends MaxFilter {
	public GreaterOrEqualsFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		return index >= maxNumber;
	}
}
