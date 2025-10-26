package bankingsystem.model;

public class KYC {
    private String customerName;
    private String dateOfBirth;       
    private String idDocumentNumber;  
    private boolean isVerified;       

    //KYC default constructor
    public KYC() {
        this.customerName = "";        
        this.dateOfBirth = "";
        this.idDocumentNumber = "";
        this.isVerified = false;
    }

    // Parametrized constructor for convinience
    public KYC(String customerName, String dateOfBirth, String idDocumentNumber) {
        this.customerName = customerName;
        this.dateOfBirth = dateOfBirth;
        this.idDocumentNumber = idDocumentNumber;
        this.isVerified = false;
    }

    
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdDocumentNumber() {
        return idDocumentNumber;
    }

    public void setIdDocumentNumber(String idDocumentNumber) {
        this.idDocumentNumber = idDocumentNumber;
    }

    public boolean isVerified() {     
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    // KYC verification method
    public void verifyKYC() {
        if (!customerName.isEmpty() && !dateOfBirth.isEmpty() && !idDocumentNumber.isEmpty()) {
            this.isVerified = true;
            System.out.println("KYC verified successfully.");
        } else {
            System.out.println("Error: KYC incomplete. Fill all fields to verify.");
        }
    }

    @Override
    public String toString() {
        return "KYC{" +
                "customerName='" + customerName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", idDocumentNumber='" + idDocumentNumber + '\'' +
                ", isVerified=" + isVerified +
                '}';
    }
}
