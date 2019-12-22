package Words.ConditionFilters;

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
	
	public static abstract class SequenceFilter extends ConditionFilter {
		protected int[] numbers;
		
		public SequenceFilter(int... numbers) {
			if (numbers.length == 0)
				throw new IllegalArgumentException();
			this.numbers = numbers;
			Arrays.sort(numbers);
		}
	}
	
	public static class NotEqualsFilter extends SequenceFilter {
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
	
	public static class EqualsFilter extends SequenceFilter {
		public EqualsFilter(int... numbers) {
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
	
	public static abstract class MinFilter extends SequenceFilter {
		protected int minNumber;
		
		public MinFilter(int... numbers) {
			super(numbers);
			minNumber = numbers[0];
		}
	}
	
	public static class LessOrEqualsFilter extends MinFilter {
		public LessOrEqualsFilter(int... numbers) {
			super(numbers);
		}
		
		@Override
		public boolean condition(int index) {
			return index <= minNumber;
		}
	}
	
	public static class LessFilter extends MinFilter {
		public LessFilter(int... numbers) {
			super(numbers);
		}
		
		@Override
		public boolean condition(int index) {
			return index < minNumber;
		}
	}
	
	public static abstract class MaxFilter extends SequenceFilter {
		protected int maxNumber;
		
		public MaxFilter(int... numbers) {
			super(numbers);
			maxNumber = numbers[numbers.length - 1];
		}
	}
	
	public static class GreaterFilter extends MaxFilter {
		public GreaterFilter(int... numbers) {
			super(numbers);
		}
		
		@Override
		public boolean condition(int index) {
			return index > maxNumber;
		}
	}
	
	public static class GreaterOrEqualsFilter extends MaxFilter {
		public GreaterOrEqualsFilter(int... numbers) {
			super(numbers);
		}
		
		@Override
		public boolean condition(int index) {
			return index >= maxNumber;
		}
	}
	
}
