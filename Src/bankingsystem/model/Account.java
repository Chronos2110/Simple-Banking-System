package bankingsystem.model;

import bankingsystem.exceptions.InsufficientBalanceException;

public class Account {
    private String accountID;
    private double balance;

    public Account(String accountID, double initialBalance) {
        this.accountID = accountID;
        this.balance = initialBalance;
    }   

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            // Using a standard exception for invalid balance.
            throw new IllegalArgumentException("Error: Balance cannot be negative.");
        }
    }

     public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount; 
            System.out.println("Amount Deposited Successfully.");
            System.out.println("Deposited: " + amount + ", New Balance: " + this.balance);
        } else {
            // Using a standard exception for invalid deposit amount.
            throw new IllegalArgumentException("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) throws InsufficientBalanceException { 
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Withdrawal amount must be positive.");
        }
        
        if (amount > this.balance) {
            /*  using a custom exception to show insufficient balance.
                rather than letting the code run each time an invalid value is entered. */
            throw new InsufficientBalanceException(
                "Error: Insufficient funds. Cannot withdraw " + amount + 
                " from balance " + this.balance
            );
        }
        
        // This part runs only if no exceptions are thrown.
        this.balance -= amount;
        System.out.println("Amount Withdrawn Successfully.");
        System.out.println("Remaining balance: " + this.balance + " After Withdrawal of: " + amount);
    }
}