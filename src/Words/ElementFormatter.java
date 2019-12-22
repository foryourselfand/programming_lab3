package Words;

import Utils.RandomHolder;

public abstract class ElementFormatter {
	private ConditionFilter conditionFilter;
	
	public ElementFormatter(ConditionFilter conditionFilter) {
		this.conditionFilter = conditionFilter;
	}
	
	public ElementFormatter() {
		this(new ConditionFilter.True());
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
			this(new ConditionFilter.True(), multiplier);
		}
		
		public Multiple(ConditionFilter conditionFilter) {
			this(conditionFilter, 1);
		}
		
		public Multiple() {
			this(new ConditionFilter.True(), 1);
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
		
		public static class Random extends Multiple {
			private int bound;
			
			public Random(ConditionFilter conditionFilter, int bound) {
				super(conditionFilter, 1);
				this.bound = bound;
			}
			
			public Random(int bound) {
				this(new ConditionFilter.True(), bound);
			}
			
			public Random(ConditionFilter conditionFilter) {
				this(conditionFilter, 1);
			}
			
			public Random() {
				this(new ConditionFilter.True(), 1);
			}
			
			@Override
			public String getFormattedElement(String elementInput) {
				multiplier = RandomHolder.getInstance().random.nextInt(bound) + 1;
				return super.getFormattedElement(elementInput);
			}
		}
	}
	
	public static abstract class Append extends ElementFormatter {
		protected String elementAppended;
		
		public Append(ConditionFilter conditionFilter, String elementAppended) {
			super(conditionFilter);
			this.elementAppended = elementAppended;
		}
		
		public Append(String elementAppended) {
			this(new ConditionFilter.True(), elementAppended);
		}
		
		public Append(ConditionFilter conditionFilter) {
			this(conditionFilter, "");
		}
		
		public Append() {
			this(new ConditionFilter.True(), "");
		}
		
		public static class Before extends Append {
			public Before(ConditionFilter conditionFilter, String elementAppended) {
				super(conditionFilter, elementAppended);
			}
			
			public Before(String elementAppended) {
				super(elementAppended);
			}
			
			public Before(ConditionFilter conditionFilter) {
				super(conditionFilter);
			}
			
			public Before() {
				super();
			}
			
			@Override
			public String getFormattedElement(String elementInput) {
				return elementAppended + elementInput;
			}
		}
		
		public static class After extends Append {
			public After(ConditionFilter conditionFilter, String elementAppended) {
				super(conditionFilter, elementAppended);
			}
			
			public After(String elementAppended) {
				super(elementAppended);
			}
			
			public After(ConditionFilter conditionFilter) {
				super(conditionFilter);
			}
			
			public After() {
				super();
			}
			
			@Override
			public String getFormattedElement(String elementInput) {
				return elementInput + elementAppended;
			}
		}
		
		public static class BeforeAndAfter extends Append {
			public BeforeAndAfter(ConditionFilter conditionFilter, String elementAppended) {
				super(conditionFilter, elementAppended);
			}
			
			public BeforeAndAfter(String elementAppended) {
				super(elementAppended);
			}
			
			public BeforeAndAfter(ConditionFilter conditionFilter) {
				super(conditionFilter);
			}
			
			public BeforeAndAfter() {
				super();
			}
			
			@Override
			public String getFormattedElement(String elementInput) {
				return elementAppended + elementInput + elementAppended;
			}
		}
	}
	
	
}
