package Assignment_solution;

import java.util.Calendar;

// Custom Exception Class for Insufficient Funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Modified WithdrawalTransaction Class with exception handling
public class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount, Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) throws InsufficientFundsException {
        if (ba.getBalance() < getAmount()) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: " + ba.getBalance());
        }
        double newBalance = ba.getBalance() - getAmount();
        ba.setBalance(newBalance);
        System.out.println("Withdrawal applied. New balance: " + newBalance);
    }

    // Overloaded apply() method
    public void apply(BankAccount ba, boolean partialWithdrawal) {
        try {
            if (ba.getBalance() > 0 && ba.getBalance() < getAmount()) {
                double remainingBalance = ba.getBalance();
                ba.setBalance(0);
                System.out.println("Partial withdrawal of " + remainingBalance + " applied. New balance: 0");
            } else if (ba.getBalance() >= getAmount()) {
                apply(ba);  // Full withdrawal
            }
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    // Overriding the reverse method for withdrawals
    public boolean reverse(BankAccount ba) {
        double newBalance = ba.getBalance() + getAmount();
        ba.setBalance(newBalance);
        System.out.println("Withdrawal reversed. New balance: " + newBalance);
        return true;
    }
}
