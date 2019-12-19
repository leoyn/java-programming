package semester3.practice.account;

import java.math.BigDecimal;
import java.util.Calendar;

import semester3.practice.account.Exceptions.*;

public class Account implements Comparable<Account> {

	private static int instanceCounter;

	protected BigDecimal balance;
	private Calendar creationDate;
	private Customer owner;

	public static int countInstances() {
		return instanceCounter;
	}

	public Account(Customer owner) {
		instanceCounter++;
		this.owner = owner;
		this.balance = BigDecimal.ZERO;
		this.creationDate = Calendar.getInstance();
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = (Calendar) creationDate.clone();
	}

	public Calendar getCreationDate() {
		return (Calendar) this.creationDate.clone();
	}

	public BigDecimal getBalance() {
		return this.balance;
	}

	public Customer getOwner() {
		return this.owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public int compareTo(Account account) {
		return this.getBalance().compareTo(account.getBalance());
	}

	public void withdraw(BigDecimal amount) throws InsufficientBalanceException, AmountTooLowException {
		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			if (this.balance.compareTo(amount) < 0)
				throw new InsufficientBalanceException("Insufficient balance");
			else
				this.balance = this.balance.subtract(amount);
		} else
			throw new AmountTooLowException("Amount is not greater than zero");
	}

	public void deposit(BigDecimal amount) throws AmountTooLowException {
		if (amount.compareTo(BigDecimal.ZERO) > 0) {
			this.balance = this.balance.add(amount);
		} else
			throw new AmountTooLowException("Amount is not greater than zero");
	}
}