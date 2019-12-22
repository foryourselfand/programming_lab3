package Utils.Exceptions;

public class LengthGreaterException extends Exception {
	public LengthGreaterException() {
		super("Length of IndexManipulator[] must be equal Length of ElementGetters[] not greater!");
	}
}
