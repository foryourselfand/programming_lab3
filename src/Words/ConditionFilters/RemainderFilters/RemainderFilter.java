package Words.ConditionFilters.RemainderFilters;

import Words.ConditionFilters.ConditionFilter;

public abstract class RemainderFilter extends ConditionFilter {
	protected int mod;
	protected int remainder;

	public RemainderFilter(int mod, int remainder) {
		this.mod = mod;
		this.remainder = remainder;
	}
}
