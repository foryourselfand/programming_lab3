package Words.ConditionFilters.SequenseFilters.LessFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public abstract class MinFilter extends SequenceFilter {
	protected int minNumber;
	
	public MinFilter(int... numbers) {
		super(numbers);
		minNumber = numbers[0];
	}
}
