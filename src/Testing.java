import Words.ElementFormatter;

public class Testing {
	public static void main(String[] args) {
		ElementFormatter elementFormatter = new ElementFormatter(String::toUpperCase, (index->index <= 1));
		if (elementFormatter.getConditionFilter().condition(0)) {
			System.out.println(elementFormatter.getStringFormatter().getFormattedString("abc"));
		}
	}
}
