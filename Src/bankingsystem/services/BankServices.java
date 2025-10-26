package bankingsystem.services;

import bankingsystem.exceptions.InsufficientBalanceException;
import bankingsystem.model.Account;

public interface BankServices {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount) throws InsufficientBalanceException;
    double checkBalance(Account account);
}

