package semester3.account;

import java.math.BigDecimal;

import semester3.account.Exceptions.*;

public class CheckingAccount extends Account {
    private BigDecimal dispoLimit;

    public CheckingAccount(Customer owner, BigDecimal dispoLimit) throws AmountTooLowException {
        super(owner);
        if(dispoLimit.compareTo(BigDecimal.ZERO) < 0) throw new AmountTooLowException("Dispolimit is negative");
        this.dispoLimit = dispoLimit;
    }

    public BigDecimal getDispoLimit() {
        return dispoLimit;
    }

    public void setDispoLimit(BigDecimal dispoLimit) {
        this.dispoLimit = dispoLimit;
    }

    public int compareTo(CheckingAccount account) {
        if(this.getBalance() == BigDecimal.ZERO && account.getBalance() == BigDecimal.ZERO) {
            return this.getDispoLimit().compareTo(account.getDispoLimit());
        }
        
        return this.getBalance().compareTo(account.getBalance());
    }

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException, AmountTooLowException {
        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal newBalance = getBalance().subtract(amount);
            if(newBalance.compareTo(this.dispoLimit.negate()) < 0) throw new InsufficientBalanceException("Insufficient balance");
            else this.balance = newBalance;
        } else throw new AmountTooLowException("Amount is not greater than zero");
    }
}