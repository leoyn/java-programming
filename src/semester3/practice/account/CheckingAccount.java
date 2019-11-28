package semester3.practice.account;

import java.math.BigDecimal;

import semester3.practice.account.Exceptions.*;

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

    public void withdraw(BigDecimal amount) throws InsufficientBalanceException, AmountTooLowException {
        if(amount.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal newBalance = getBalance().subtract(amount);
            if(newBalance.compareTo(this.dispoLimit.negate()) < 0) throw new InsufficientBalanceException("Insufficient balance");
            else this.balance = newBalance;
        } else throw new AmountTooLowException("Amount is not greater than zero");
    }
}