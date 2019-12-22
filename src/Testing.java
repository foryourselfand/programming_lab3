import Words.Holder;

public class Testing {
	public static void main(String[] args) {
		Holder holder = new Holder(String::toUpperCase, (index->index <= 1));
		if (holder.getConditionFilter().condition(0)) {
			System.out.println(holder.getStringFormatter().getFormattedString("abc"));
		}
	}
}
