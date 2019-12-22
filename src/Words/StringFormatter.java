package Words;

import Utils.RandomHolder;

public interface StringFormatter {
	String getFormattedString(String element);
	
	class Default implements StringFormatter {
		@Override
		public String getFormattedString(String elementInput) {
			return elementInput;
		}
	}
	
	class Upper implements StringFormatter {
		@Override
		public String getFormattedString(String elementInput) {
			return elementInput.toUpperCase();
		}
	}
	
	class Lower implements StringFormatter {
		@Override
		public String getFormattedString(String elementInput) {
			return elementInput.toLowerCase();
		}
	}
	
	class Reverse implements StringFormatter {
		@Override
		public String getFormattedString(String elementInput) {
			return new StringBuilder(elementInput).reverse().toString();
		}
	}
	
	class Mirror implements StringFormatter {
		@Override
		public String getFormattedString(String elementInput) {
			return elementInput + new StringBuilder(elementInput).reverse().toString();
		}
	}
	
	class Multiple implements StringFormatter {
		protected int multiplier;
		
		public Multiple(int multiplier) {
			this.multiplier = multiplier;
		}
		
		public Multiple() {
			this(1);
		}
		
		@Override
		public String getFormattedString(String elementInput) {
			if (multiplier == 1)
				return elementInput;
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < multiplier; i++)
				stringBuilder.append(elementInput);
			return stringBuilder.toString();
		}
		
		public static class Random extends Multiple {
			private int bound;
			
			public Random(int bound) {
				super(1);
				this.bound = bound;
			}
			
			public Random() {
				this(1);
			}
			
			@Override
			public String getFormattedString(String elementInput) {
				multiplier = RandomHolder.getInstance().random.nextInt(bound) + 1;
				return super.getFormattedString(elementInput);
			}
		}
	}
	
	abstract class Append implements StringFormatter {
		protected String elementAppended;
		
		public Append(String elementAppended) {
			this.elementAppended = elementAppended;
		}
		
		public Append() {
			this("");
		}
		
		public static class Before extends Append {
			public Before(String elementAppended) {
				super(elementAppended);
			}
			
			public Before() {
				super();
			}
			
			@Override
			public String getFormattedString(String elementInput) {
				return elementAppended + elementInput;
			}
		}
		
		public static class After extends Append {
			public After(String elementAppended) {
				super(elementAppended);
			}
			
			public After() {
				super();
			}
			
			@Override
			public String getFormattedString(String elementInput) {
				return elementInput + elementAppended;
			}
		}
		
		public static class BeforeAndAfter extends Append {
			public BeforeAndAfter(String elementAppended) {
				super(elementAppended);
			}
			
			public BeforeAndAfter() {
				super();
			}
			
			@Override
			public String getFormattedString(String elementInput) {
				return elementAppended + elementInput + elementAppended;
			}
		}
	}
}
