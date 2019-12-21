package Words.ConditionFilters.RemainderFilters.RemainderEqualsNumber;

import Words.ConditionFilters.RemainderFilters.RemainderFilter;

public class RemainderEqualsNumberFilter extends RemainderFilter {
	public RemainderEqualsNumberFilter(int mod, int remainder) {
		super(mod, remainder);
	}
	
	@Override
	public boolean condition(int index) {
		return (index % mod) == remainder;
	}
}
