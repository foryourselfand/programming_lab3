package Words.ConditionFilters.SequenseFilters;

import Words.ConditionFilters.ConditionFilter;

import java.util.Arrays;

public abstract class SequenceFilter extends ConditionFilter {
	protected int[] numbers;

	public SequenceFilter(int... numbers) {
		if (numbers.length == 0)
			throw new IllegalArgumentException();
		this.numbers = numbers;
		Arrays.sort(numbers);
	}
}
