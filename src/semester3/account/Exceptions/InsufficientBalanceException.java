package semester3.account.Exceptions;

public class InsufficientBalanceException extends Exception {
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
