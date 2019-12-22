package Utils.Exceptions;

public class WrongIndexManipulatorStart extends RuntimeException {
	public WrongIndexManipulatorStart() {
		super("startIndexManipulator can't be instance of IndexWithLastManipulator");
	}
}
