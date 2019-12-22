package Words;

import Utils.RandomHolder;

import java.util.Arrays;

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
		
		public static class Half extends Random {
			public Half() {
				super(0.5f);
			}
		}
		
		public static class Wrapper extends Random {
			private ConditionFilter conditionFilter;
			
			public Wrapper(float probability, ConditionFilter conditionFilter) {
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
		
		public static class HalfWrapper extends Wrapper {
			public HalfWrapper(ConditionFilter conditionFilter) {
				super(0.5f, conditionFilter);
			}
		}
	}
	
	public static abstract class Remainder extends ConditionFilter {
		protected int mod;
		protected int remainder;
		
		public Remainder(int mod, int remainder) {
			this.mod = mod;
			this.remainder = remainder;
		}
		
		public static class EqualsNumber extends Remainder {
			public EqualsNumber(int mod, int remainder) {
				super(mod, remainder);
			}
			
			@Override
			public boolean condition(int index) {
				return (index % mod) == remainder;
			}
		}
		
		public static class NotEqualsNumber extends Remainder {
			public NotEqualsNumber(int mod, int remainder) {
				super(mod, remainder);
			}
			
			@Override
			public boolean condition(int index) {
				return (index % mod) != remainder;
			}
		}
		
		public static class EqualsOne extends EqualsNumber {
			public EqualsOne(int mod) {
				super(mod, 1);
			}
		}
		
		public static class EqualsZero extends EqualsNumber {
			public EqualsZero(int mod) {
				super(mod, 0);
			}
		}
		
		public static class Odd extends EqualsOne {
			public Odd() {
				super(2);
			}
		}
		
		public static class Even extends EqualsZero {
			public Even() {
				super(2);
			}
		}
	}
	
	public static abstract class Sequence extends ConditionFilter {
		protected int[] numbers;
		
		public Sequence(int... numbers) {
			if (numbers.length == 0)
				throw new IllegalArgumentException();
			this.numbers = numbers;
			Arrays.sort(numbers);
		}
		
		public static class Equals extends Sequence {
			public Equals(int... numbers) {
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
		
		public static class NotEquals extends Sequence {
			public NotEquals(int... numbers) {
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
		
		public static abstract class Min extends Sequence {
			protected int minNumber;
			
			public Min(int... numbers) {
				super(numbers);
				minNumber = numbers[0];
			}
		}
		
		public static class LessOrEquals extends Min {
			public LessOrEquals(int... numbers) {
				super(numbers);
			}
			
			@Override
			public boolean condition(int index) {
				return index <= minNumber;
			}
		}
		
		public static class Less extends Min {
			public Less(int... numbers) {
				super(numbers);
			}
			
			@Override
			public boolean condition(int index) {
				return index < minNumber;
			}
		}
		
		public static abstract class Max extends Sequence {
			protected int maxNumber;
			
			public Max(int... numbers) {
				super(numbers);
				maxNumber = numbers[numbers.length - 1];
			}
		}
		
		public static class Greater extends Max {
			public Greater(int... numbers) {
				super(numbers);
			}
			
			@Override
			public boolean condition(int index) {
				return index > maxNumber;
			}
		}
		
		public static class GreaterOrEquals extends Max {
			public GreaterOrEquals(int... numbers) {
				super(numbers);
			}
			
			@Override
			public boolean condition(int index) {
				return index >= maxNumber;
			}
		}
	}
}
