package Words.ElementFormatters;

import Utils.RandomHolder;
import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;

public abstract class ElementFormatter {
	private ConditionFilter conditionFilter;
	
	public ElementFormatter(ConditionFilter conditionFilter) {
		this.conditionFilter = conditionFilter;
	}
	
	public ElementFormatter() {
		this(new TrueFilter());
	}
	
	public boolean getCondition(int index) {
		return conditionFilter.condition(index);
	}
	
	public abstract String getFormattedElement(String elementInput);
	
	public static class Default extends ElementFormatter {
		public Default(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public Default() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementInput;
		}
	}
	
	public static class Upper extends ElementFormatter {
		public Upper(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public Upper() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementInput.toUpperCase();
		}
	}
	
	public static class Lower extends ElementFormatter {
		public Lower(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public Lower() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementInput.toLowerCase();
		}
	}
	
	public static class Reverse extends ElementFormatter {
		public Reverse(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public Reverse() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return new StringBuilder(elementInput).reverse().toString();
		}
	}
	
	public static class Mirror extends ElementFormatter {
		public Mirror(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public Mirror() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementInput + new StringBuilder(elementInput).reverse().toString();
		}
	}
	
	public static class Multiple extends ElementFormatter {
		protected int multiplier;
		
		public Multiple(ConditionFilter conditionFilter, int multiplier) {
			super(conditionFilter);
			this.multiplier = multiplier;
		}
		
		public Multiple(int multiplier) {
			this(new TrueFilter(), multiplier);
		}
		
		public Multiple(ConditionFilter conditionFilter) {
			this(conditionFilter, 1);
		}
		
		public Multiple() {
			this(new TrueFilter(), 1);
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			if (multiplier == 1)
				return elementInput;
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < multiplier; i++)
				stringBuilder.append(elementInput);
			return stringBuilder.toString();
		}
	}
	
	public static class MultiplyRandom extends Multiple {
		private int bound;
		
		public MultiplyRandom(ConditionFilter conditionFilter, int bound) {
			super(conditionFilter, 1);
			this.bound = bound;
		}
		
		public MultiplyRandom(int bound) {
			this(new TrueFilter(), bound);
		}
		
		public MultiplyRandom(ConditionFilter conditionFilter) {
			this(conditionFilter, 1);
		}
		
		public MultiplyRandom() {
			this(new TrueFilter(), 1);
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			multiplier = RandomHolder.getInstance().random.nextInt(bound) + 1;
			return super.getFormattedElement(elementInput);
		}
	}
	
	private static abstract class Append extends ElementFormatter {
		protected String elementAppended;
		
		public Append(ConditionFilter conditionFilter, String elementAppended) {
			super(conditionFilter);
			this.elementAppended = elementAppended;
		}
		
		public Append(String elementAppended) {
			this(new TrueFilter(), elementAppended);
		}
		
		public Append(ConditionFilter conditionFilter) {
			this(conditionFilter, "");
		}
		
		public Append() {
			this(new TrueFilter(), "");
		}
	}
	
	public static class AppendBefore extends Append {
		public AppendBefore(ConditionFilter conditionFilter, String elementAppended) {
			super(conditionFilter, elementAppended);
		}
		
		public AppendBefore(String elementAppended) {
			super(elementAppended);
		}
		
		public AppendBefore(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public AppendBefore() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementAppended + elementInput;
		}
	}
	
	public static class AppendAfter extends Append {
		public AppendAfter(ConditionFilter conditionFilter, String elementAppended) {
			super(conditionFilter, elementAppended);
		}
		
		public AppendAfter(String elementAppended) {
			super(elementAppended);
		}
		
		public AppendAfter(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public AppendAfter() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementInput + elementAppended;
		}
	}
	
	public static class AppendBeforeAndAfter extends Append {
		public AppendBeforeAndAfter(ConditionFilter conditionFilter, String elementAppended) {
			super(conditionFilter, elementAppended);
		}
		
		public AppendBeforeAndAfter(String elementAppended) {
			super(elementAppended);
		}
		
		public AppendBeforeAndAfter(ConditionFilter conditionFilter) {
			super(conditionFilter);
		}
		
		public AppendBeforeAndAfter() {
			super();
		}
		
		@Override
		public String getFormattedElement(String elementInput) {
			return elementAppended + elementInput + elementAppended;
		}
	}
}
