package Words.ConditionFilters.SequenseFilters.LessFilters;

import Words.ConditionFilters.SequenseFilters.SequenceFilter;

public class LessFilter extends SequenceFilter {
	public LessFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		int minNumber = numbers[0];
		return index < minNumber;
	}
}
