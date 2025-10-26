package bankingsystem.services;

import bankingsystem.model.KYC;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AdManager {
    public String getAdForUser(KYC kyc) {
        if (kyc.getDateOfBirth() == null || kyc.getDateOfBirth().isEmpty()) {
            
            return "No ads available until KYC is complete.";
        }
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate dob = LocalDate.parse(kyc.getDateOfBirth(), formatter);
            int age = Period.between(dob, LocalDate.now()).getYears();

            if (age < 21) {
                
                return "Student Loan Offer: Finance your studies easily!";
            } else if (age < 35) {
                
                return "Car Loan Offer: Drive your dream car today!";
            } else {
                
                return "Home Loan Offer: Build your dream home with us!";
            }
        } catch (DateTimeParseException e) {
            
            return "Invalid DOB format. Please use DD-MM-YYYY.";
        }
    }
}
