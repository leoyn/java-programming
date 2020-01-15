package semester3.practice.account;

import java.util.ArrayList;

public class Customer {
    private String firstname;
    private String lastname;
    private Password password;
    public ArrayList<Account> accounts;

    public Customer(String firstname, String lastname) {
        this.accounts = new ArrayList<Account>();
        this.firstname = firstname;
    }

    public boolean changePassword(String oldPassword, String newPassword) {
        if(!checkPassword(oldPassword)) return false;
        
        this.password = new Password(newPassword);
        return true;
    }

    public boolean checkPassword(String password) {
        if(this.password == null) return password == null;
        return this.password.equals(new Password(password));
    }

    public String getFirstname() {
        return this.firstname;
    }

    public Password getPassword() {
        return this.password;
    }

    public String getLastname() {
        return this.lastname;
    }
}