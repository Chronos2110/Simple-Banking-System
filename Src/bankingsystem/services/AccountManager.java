package bankingsystem.services;

import bankingsystem.model.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String, Account> accounts = new HashMap<>();

    public void createAccount(String accountID, double initialBalance) {
        accounts.put(accountID, new Account(accountID, initialBalance));
    }

    public Account getAccount(String accountID) {
        return accounts.get(accountID);
    }

    public boolean accountExists(String accountID) {
        return accounts.containsKey(accountID);
    }
}
