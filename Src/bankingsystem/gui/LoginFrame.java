package bankingsystem.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;
import bankingsystem.model.Account;
import bankingsystem.model.KYC;
import bankingsystem.services.AccountManager;
import bankingsystem.utils.OTPGenerator;

public class LoginFrame extends Frame implements ActionListener {
    AccountManager accManager;
    Map<String, KYC> kycDb;
    TextField tfId, tfOtp;
    Button btnGetOtp, btnLogin;
    Label lblInfo;
    String generatedOtp;

    public LoginFrame(AccountManager am, Map<String, KYC> kyc) {
        this.accManager = am;
        this.kycDb = kyc;
        setTitle("Bank Login");
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(350, 200);

        add(new Label("Account ID:"));
        tfId = new TextField("12345");
        add(tfId);

        btnGetOtp = new Button("Get OTP");
        add(btnGetOtp);
        lblInfo = new Label("Click button to get OTP.");
        add(lblInfo);

        add(new Label("Enter OTP:"));
        tfOtp = new TextField();
        tfOtp.setEditable(false);
        add(tfOtp);

        add(new Label());
        btnLogin = new Button("Login");
        btnLogin.setEnabled(false);
        add(btnLogin);

        btnGetOtp.addActionListener(this);
        btnLogin.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnGetOtp) {
            String accId = tfId.getText();
            if (accManager.getAccount(accId) != null) {
                generatedOtp = OTPGenerator.generateOTP(); // corrected method name
                lblInfo.setText("OTP: " + generatedOtp);
                tfOtp.setEditable(true);
                btnLogin.setEnabled(true);
            } else {
                lblInfo.setText("Account not found.");
            }
        } else if (e.getSource() == btnLogin) {
            if (tfOtp.getText().equals(generatedOtp)) {
                String accId = tfId.getText();
                Account acc = accManager.getAccount(accId);
                KYC kyc = kycDb.get(accId);

                if (kyc.isVerified()) {
                    new MainFrame(acc, kyc).setVisible(true);
                } else {
                    new KYCFrame(acc, kyc).setVisible(true);
                }
                this.dispose();
            } else {
                lblInfo.setText("Invalid OTP.");
            }
        }
    }
}