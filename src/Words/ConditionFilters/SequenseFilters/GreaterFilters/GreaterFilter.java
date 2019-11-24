package Words.ConditionFilters.SequenseFilters.GreaterFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public class GreaterFilter extends SequenceFilter {
	public GreaterFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		int maxNumber = numbers[numbers.length - 1];
		return index > maxNumber;
	}
}
