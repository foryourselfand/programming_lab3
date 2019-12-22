package Utils.Exceptions;

public class LengthZeroException extends Exception {
	public LengthZeroException() {
		super("Length of ElementGetters[] must be greater that zero!");
	}
}
