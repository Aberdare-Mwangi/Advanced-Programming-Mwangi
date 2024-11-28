package Assignment_solution;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws InsufficientFundsException {
        // Create a BankAccount
        BankAccount account = new BankAccount(500);  // Initial balance is 500

        // Test DepositTransaction
        Calendar depositDate = new GregorianCalendar();
        DepositTransaction deposit = new DepositTransaction(300, depositDate);
        deposit.apply(account);  // Applying deposit
        deposit.printTransactionDetails();

        // Test WithdrawalTransaction with sufficient funds
        Calendar withdrawalDate = new GregorianCalendar();
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(200, withdrawalDate);
        withdrawal.apply(account);  // Applying withdrawal
        withdrawal.printTransactionDetails();

        // Test WithdrawalTransaction with insufficient funds (Exception handling)
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(1000, withdrawalDate);
        try {
            largeWithdrawal.apply(account);  // This should throw InsufficientFundsException
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        // Test reverse method for withdrawals
        withdrawal.reverse(account);
    }
}
