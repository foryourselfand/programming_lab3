package Words.ElementFormatters.AppendElementFormatters;

import Words.ConditionFilters.ConditionFilter;
import Words.ConditionFilters.TrueFilter;
import Words.ElementFormatters.ElementFormatter;

public abstract class AppendElementFormatter extends ElementFormatter {
	protected String elementAppended;

	public AppendElementFormatter(ConditionFilter conditionFilter, String elementAppended) {
		super(conditionFilter);
		this.elementAppended = elementAppended;
	}

	public AppendElementFormatter(String elementAppended) {
		this(new TrueFilter(), elementAppended);
	}

	public AppendElementFormatter(ConditionFilter conditionFilter) {
		this(conditionFilter, "");
	}

	public AppendElementFormatter() {
		this(new TrueFilter(), "");
	}
}
