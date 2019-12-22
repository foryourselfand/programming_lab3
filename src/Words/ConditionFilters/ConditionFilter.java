package Words.ConditionFilters;

import Utils.RandomHolder;

public abstract class ConditionFilter {
	public abstract boolean condition(int index);
	
	public static class True extends ConditionFilter {
		@Override
		public boolean condition(int index) {
			return true;
		}
	}
	
	public static class False extends ConditionFilter {
		@Override
		public boolean condition(int index) {
			return false;
		}
	}
	
	public static class Random extends ConditionFilter {
		private float probability;
		
		public Random(float probability) {
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
	
	public static class RandomWrapper extends Random {
		private ConditionFilter conditionFilter;
		
		public RandomWrapper(float probability, ConditionFilter conditionFilter) {
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
	
	public static class RandomHalf extends Random {
		public RandomHalf() {
			super(0.5f);
		}
	}
	
	public static class RandomHalfWrapper extends RandomWrapper {
		public RandomHalfWrapper(ConditionFilter conditionFilter) {
			super(0.5f, conditionFilter);
		}
	}
	
	public static abstract class Remainder extends ConditionFilter {
		protected int mod;
		protected int remainder;
		
		public Remainder(int mod, int remainder) {
			this.mod = mod;
			this.remainder = remainder;
		}
	}
	
	public static class RemainderOdd extends RemainderEqualsOne {
		public RemainderOdd() {
			super(2);
		}
	}
	
	public static class RemainderEven extends RemainderEqualsZero {
		public RemainderEven() {
			super(2);
		}
	}
	
	public static class RemainderEqualsNumber extends Remainder {
		public RemainderEqualsNumber(int mod, int remainder) {
			super(mod, remainder);
		}
		
		@Override
		public boolean condition(int index) {
			return (index % mod) == remainder;
		}
	}
	
	public static class RemainderNotEqualsNumber extends Remainder {
		public RemainderNotEqualsNumber(int mod, int remainder) {
			super(mod, remainder);
		}
		
		@Override
		public boolean condition(int index) {
			return (index % mod) != remainder;
		}
	}
	
	public static class RemainderEqualsOne extends RemainderEqualsNumber {
		public RemainderEqualsOne(int mod) {
			super(mod, 1);
		}
	}
	
	public static class RemainderEqualsZero extends RemainderEqualsNumber {
		public RemainderEqualsZero(int mod) {
			super(mod, 0);
		}
	}
	
}
