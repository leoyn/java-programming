package semester3.practice.account;

import java.util.ArrayList;

public class Customer {
    private String firstname;
    private String lastname;
    public ArrayList<Account> accounts;

    public Customer(String firstname, String lastname) {
        this.accounts = new ArrayList<Account>();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }
}