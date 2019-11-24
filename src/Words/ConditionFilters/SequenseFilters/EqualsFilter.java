package Words.ConditionFilters.SequenseFilters;

public class EqualsFilter extends SequenceFilter {
	public EqualsFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		for (int number : numbers)
			if (number == index)
				return true;
		return false;
	}
}
