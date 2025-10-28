# Simple Banking System  

A desktop-based Java application that simulates basic banking operations such as login, OTP verification, KYC authentication, deposit, withdrawal, and balance inquiry.  
This project was developed as part of the Object-Oriented Programming Laboratory (Semester III) at K. J. Somaiya School of Engineering.

---

## Project Overview  
The Simple Banking System replicates a basic banking environment with secure user authentication and a graphical interface built using Java AWT.  
It shows the use of Object-Oriented Programming (OOP) principles and modular design through packages and separate logic, model, and GUI layers.

### Features
- Secure login with OTP verification
- KYC verification page for collecting user details  
- Core banking functions: deposit, withdrawal, and balance check  
- Personalized ads displayed based on user age  
- Custom exception handling for invalid transactions  
- Simple AWT GUI with a clean and minimal design  

---

## System Architecture  

The project is divided into multiple packages to maintain organization:  
- `main` → Entry point of the application (`Main.java`)  
- `gui` → Frames for login, KYC, and main dashboard  
- `model` → Classes for account and KYC details  
- `services` → Logic for account management, transactions, and advertisements  
- `utils` → Helper classes like `OTPGenerator`  
- `exceptions` → Custom exception `InsufficientBalanceException`  

**Flow of Execution:**  
`LoginFrame → OTP Verification → KYCFrame → MainFrame → Personalized Ads`

---

## Technologies Used
- Programming Language: Java  
- GUI Toolkit: AWT (Abstract Window Toolkit)  
- Concepts: OOP (Encapsulation, Abstraction, Modularity)  
- Libraries: `java.util.Random` for OTP generation  
- IDE Used: IntelliJ IDEA / Eclipse (any preferred Java IDE)  

---

## How to Run the Project  

1. Clone this repository:  
   ```bash
   git clone https://github.com/Chronos2110/Simple-Banking-System.git
```  
