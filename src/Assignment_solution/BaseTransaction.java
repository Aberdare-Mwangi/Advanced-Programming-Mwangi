package Assignment_solution;

import java.util.Calendar;
import java.util.UUID;

// BaseTransaction Class that implements TransactionInterface
public class BaseTransaction implements TransactionInterface {
    private double amount;
    private Calendar date;
    private String transactionID;

    public BaseTransaction(double amount, Calendar date) {
        this.amount = amount;
        this.date = date;
        this.transactionID = UUID.randomUUID().toString();  // Generating a unique transaction ID
    }

    // Implementing the abstract methods from TransactionInterface
    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    // Common method to print transaction details
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + getTransactionID());
        System.out.println("Amount: " + getAmount());
        System.out.println("Date: " + getDate().getTime());
    }

    // Method to apply the transaction to a BankAccount (Base implementation)
    public void apply(BankAccount ba) throws InsufficientFundsException {
        System.out.println("Base transaction applied. Override this method in subclasses.");
    }
}

