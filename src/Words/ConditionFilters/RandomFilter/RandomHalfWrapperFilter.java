package Words.ConditionFilters.RandomFilter;

import Words.ConditionFilters.ConditionFilter;

public class RandomHalfWrapperFilter extends RandomWrapperFilter {
	public RandomHalfWrapperFilter(ConditionFilter conditionFilter) {
		super(0.5f, conditionFilter);
	}
}
