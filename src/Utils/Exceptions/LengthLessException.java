package Utils.Exceptions;

public class LengthLessException extends Exception {
	public LengthLessException() {
		super("Length of IndexManipulator[] must be equal Length of ElementGetters[] not less!");
	}
}
