package Words.ConditionFilters.RandomFilter;

import Utils.RandomHolder;
import Words.ConditionFilters.ConditionFilter;

public class RandomFilter extends ConditionFilter {
	private float probability;
	
	public RandomFilter(float probability) {
		this.probability = probability;
	}
	
	public boolean randomCondition() {
		return RandomHolder.getInstance().random.nextFloat() <= probability;
	}
	
	@Override
	public boolean condition(int index) {
		return randomCondition();
	}
}
