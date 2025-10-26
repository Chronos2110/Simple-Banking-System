package bankingsystem.gui;

import java.awt.*;
import java.awt.event.*;
import bankingsystem.model.Account;
import bankingsystem.model.KYC;

public class KYCFrame extends Frame implements ActionListener {
    Account account;
    KYC kyc;
    TextField tfName, tfDob, tfDocId;
    Button btnSubmit;

    public KYCFrame(Account acc, KYC kyc) {
        this.account = acc;
        this.kyc = kyc;
        setTitle("KYC Verification");
        setLayout(new GridLayout(4, 2, 10, 10));
        setSize(400, 200);

        add(new Label("Full Name:"));
        tfName = new TextField();
        add(tfName);

        add(new Label("DOB (dd-MM-yyyy):"));
        tfDob = new TextField();
        add(tfDob);

        add(new Label("Document ID:"));
        tfDocId = new TextField();
        add(tfDocId);

        add(new Label());
        btnSubmit = new Button("Submit");
        add(btnSubmit);

        btnSubmit.addActionListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kyc.setCustomerName(tfName.getText());
        kyc.setDateOfBirth(tfDob.getText());
        kyc.setIdDocumentNumber(tfDocId.getText());
        kyc.verifyKYC();

        new MainFrame(account, kyc).setVisible(true);
        this.dispose();
    }
}