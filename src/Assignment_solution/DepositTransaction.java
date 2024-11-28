package Assignment_solution;

import java.util.Calendar;

// DepositTransaction Class
public class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) {
        double newBalance = ba.getBalance() + getAmount();
        ba.setBalance(newBalance);
        System.out.println("Deposit applied. New balance: " + newBalance);
    }
}

