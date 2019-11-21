package semester3.practice.account;

import java.math.BigDecimal;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) throws Exception {
		Account account1 = Account.create(new Person("Jane", "Doe"));
		
		account1.deposit(new BigDecimal(300));
		System.out.println(account1.getBalance());
		
		account1.withdraw(new BigDecimal(123));
		System.out.println(account1.getBalance());
		
		account1.getCreationDate().set(2020, 0, 1);
		
		Calendar creationDate = account1.getCreationDate();

		System.out.println("Number of Accounts: " + Account.countInstances());

		account1.setOwner(new Person("John", "Doe"));
		
		/*
		 * Calendar is a pointer --> mutable object even tough it is private
		 * immutable objects return a new object clone
		 */
		
		System.out.println(creationDate.get(Calendar.DAY_OF_MONTH) + "." + creationDate.get(Calendar.MONTH) + "." + creationDate.get(Calendar.YEAR));
	
		/*
		 * double is not 0.6, but when we pass it as a string the number is correct.
		 */
		
		System.out.println();
		System.out.println(new BigDecimal("0.6") + " ≠ " + new BigDecimal(0.6));
	}
}
