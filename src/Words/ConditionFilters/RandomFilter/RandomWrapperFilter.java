package Words.ConditionFilters.RandomFilter;

import Words.ConditionFilters.ConditionFilter;

public class RandomWrapperFilter extends RandomFilter {
	private ConditionFilter conditionFilter;

	public RandomWrapperFilter(float probability, ConditionFilter conditionFilter) {
		super(probability);
		this.conditionFilter = conditionFilter;
	}

	@Override
	public boolean condition(int index) {
		if (randomCondition())
			return conditionFilter.condition(index);
		return false;
	}
}
