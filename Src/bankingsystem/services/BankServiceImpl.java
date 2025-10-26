package bankingsystem.services;

import bankingsystem.exceptions.InsufficientBalanceException;
import bankingsystem.model.Account;

public class BankServiceImpl implements BankServices {
    public void deposit(Account account, double amount) {
        account.deposit(amount);
    }

    public void withdraw(Account account, double amount) throws InsufficientBalanceException {
        account.withdraw(amount);
    }

    public double checkBalance(Account account) {
        return account.getBalance();
    }
}
