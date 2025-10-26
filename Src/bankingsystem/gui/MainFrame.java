package bankingsystem.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import bankingsystem.model.Account;
import bankingsystem.model.KYC;
import bankingsystem.services.AdManager;
import bankingsystem.exceptions.InsufficientBalanceException;
import bankingsystem.services.BankServiceImpl;
import bankingsystem.services.BankServices;


public class MainFrame extends Frame implements ActionListener {
    Account account;
    KYC kyc;
    BankServices bankService = new BankServiceImpl();
    AdManager adManager = new AdManager();
    Label lblWelcome, lblBalance, lblAd;
    TextField tfAmount;
    Button btnDeposit, btnWithdraw, btnLogout;

    public MainFrame(Account acc, KYC kyc) {
        this.account = acc;
        this.kyc = kyc;
        setTitle("Bank Account");
        setLayout(new GridLayout(5, 2, 10, 10));
        setSize(400, 250);

        lblWelcome = new Label("Welcome, " + kyc.getCustomerName());
        add(lblWelcome);
        lblAd = new Label(adManager.getAdForUser(kyc));
        add(lblAd);

        lblBalance = new Label();
        add(lblBalance);
        add(new Label());

        add(new Label("Amount:"));
        tfAmount = new TextField();
        add(tfAmount);

        btnDeposit = new Button("Deposit");
        add(btnDeposit);
        btnWithdraw = new Button("Withdraw");
        add(btnWithdraw);

        add(new Label());
        btnLogout = new Button("Logout");
        add(btnLogout);

        btnDeposit.addActionListener(this);
        btnWithdraw.addActionListener(this);
        btnLogout.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
        updateBalance();
    }

    private void updateBalance() {
        lblBalance.setText("Balance: $" + String.format("%.2f", account.getBalance()));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == btnDeposit || e.getSource() == btnWithdraw) {
                double amount = Double.parseDouble(tfAmount.getText());
                if (e.getSource() == btnDeposit) {
                    bankService.deposit(account, amount);
                } else {
                    bankService.withdraw(account, amount);
                }
                updateBalance();
                tfAmount.setText("");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        } catch (InsufficientBalanceException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }

        if (e.getSource() == btnLogout) {
            System.exit(0);
        }
    }
}