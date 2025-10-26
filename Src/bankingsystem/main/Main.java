// src/bankingsystem/main/Main.java
package bankingsystem.main;

import bankingsystem.model.KYC;
import bankingsystem.services.AccountManager;
import bankingsystem.gui.LoginFrame;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Create the services that will be shared across frames
        AccountManager accManager = new AccountManager();
        Map<String, KYC> kycDatabase = new HashMap<>();

        // 2. Create a sample user for testing
        String userId = "12345";
        accManager.createAccount(userId, 1000.0);
        // User starts with an unverified KYC object
        kycDatabase.put(userId, new KYC("", "", ""));
        
        // 3. Start the application by creating the LoginFrame
        // We pass the backend services to the GUI
        LoginFrame login = new LoginFrame(accManager, kycDatabase);
        login.setVisible(true);
    }
}