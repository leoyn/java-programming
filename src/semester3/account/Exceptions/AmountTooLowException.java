package semester3.account.Exceptions;

public class AmountTooLowException extends Exception {
	private static final long serialVersionUID = 1L;

	public AmountTooLowException(String message) {
		super(message);
	}
}
