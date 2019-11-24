package Words.ConditionFilters.SequenseFilters;

public class NotEqualsFilter extends SequenceFilter {
	public NotEqualsFilter(int... numbers) {
		super(numbers);
	}

	@Override
	public boolean condition(int index) {
		for (int number : numbers)
			if (number == index)
				return false;
		return true;
	}
}
