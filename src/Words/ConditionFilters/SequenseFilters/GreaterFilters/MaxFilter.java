package Words.ConditionFilters.SequenseFilters.GreaterFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public abstract class MaxFilter extends SequenceFilter {
	protected int maxNumber;
	
	public MaxFilter(int... numbers) {
		super(numbers);
		maxNumber = numbers[numbers.length - 1];
	}
}
