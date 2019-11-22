public class Main {
	public static void main(String[] args) {
		Owl owl = new Owl();

		Him him = new Him(owl);

		owl.setMessage("One");
		owl.setMessage("Two");
		owl.setMessage("Three");
	}
}
