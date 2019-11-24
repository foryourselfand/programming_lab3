package Words.ConditionFilters.SequenseFilters.GreaterFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public class GreaterFilter extends MaxFilter {
	public GreaterFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		return index > maxNumber;
	}
}
