package semester3.practice.account;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private BigDecimal interest;
    
    public SavingsAccount(Customer owner,  BigDecimal interest) {
        super(owner);
        this.interest = interest;
    }

    public BigDecimal getInterest() {
        return this.interest;
    }
}