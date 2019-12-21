package Words.ConditionFilters.SequenseFilters.LessFilters;

public class LessOrEqualsFilter extends MinFilter {
	public LessOrEqualsFilter(int... numbers) {
		super(numbers);
	}
	
	@Override
	public boolean condition(int index) {
		return index <= minNumber;
	}
}
