package semester3.account;

import java.math.BigDecimal;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) throws Exception {
		Account testAccount = new CheckingAccount(new Customer("Jane", "Doe"), new BigDecimal(100));

		testAccount.deposit(new BigDecimal(300));
		System.out.println(testAccount.getBalance());

		testAccount.withdraw(new BigDecimal(400));
		System.out.println(testAccount.getBalance());

		testAccount.getCreationDate().set(2020, 0, 1);

		Calendar creationDate = testAccount.getCreationDate();

		System.out.println("Number of Accounts: " + Account.countInstances());

		testAccount.setOwner(new Customer("John", "Doe"));

		/*
		 * Calendar is a pointer --> mutable object even tough it is private.
		 * immutable objects return a new object clone
		 */

		System.out.println(creationDate.get(Calendar.DAY_OF_MONTH) + "." + creationDate.get(Calendar.MONTH) + "." + creationDate.get(Calendar.YEAR));


		/*
		 * double is not 0.6, but when we pass it as a string the number is correct.
		 */

		System.out.println();
		System.out.println(new BigDecimal("0.6") + " ≠ " + new BigDecimal(0.6));

		/*
		 * Casting to CheckingAccount to access its methods
		 * 
		 * Account = static type 
		 * CheckingAccount = dynamic type
		 */

		((CheckingAccount) testAccount).getDispoLimit();


		Customer customer = new Customer("Jane", "Doe");
		customer.accounts.add(new CheckingAccount(customer, new BigDecimal(100)));
		customer.accounts.add(new CheckingAccount(customer, BigDecimal.ZERO));

		/*
		 * Lambda functions
		 */

		customer.accounts.stream().sorted((account1, account2) -> {
			return account1.compareTo(account2);
		}).forEach(acc -> {
			System.out.println("Balance: " + acc.getBalance());
		});

		System.out.println();

		/*
		 * Lambda function using filters
		 * Sorting checking accounts
		 */

		customer.accounts.stream().filter(account -> {
			return account instanceof CheckingAccount;
		}).map(account -> {
			return (CheckingAccount) account;
		}).sorted((acc1, acc2) -> {
			return acc1.compareTo(acc2);
		}).forEach(account -> {
			System.out.println("Dispolimit: " + account.getDispoLimit());
			System.out.println("Balance: " + account.getBalance());
		});
	}
}
