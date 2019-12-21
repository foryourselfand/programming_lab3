package Words.ConditionFilters.SequenseFilters.LessFilters;

public class LessFilter extends MinFilter {
	public LessFilter(int... numbers) {
		super(numbers);
	}
	
	@Override
	public boolean condition(int index) {
		return index < minNumber;
	}
}
