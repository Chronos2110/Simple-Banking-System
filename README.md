# 💳 Simple Banking System  

A desktop-based **Java application** that simulates basic banking operations such as Login, OTP Verification, KYC Authentication, Deposit, Withdraw, and Balance Inquiry.  
This project was developed as part of the **Object-Oriented Programming Laboratory (Semester III)** at **K. J. Somaiya School of Engineering**.

---

## 🧠 Project Overview  
The **Simple Banking System** is designed to replicate a basic banking environment with secure user authentication and a graphical interface built using **Java AWT**.  
It demonstrates the use of **Object-Oriented Programming (OOP)** principles and modular design through packages and separate logic, model, and GUI layers.

### 🔑 Features
- **Secure Login with OTP Verification**
- **KYC Verification Page** for collecting user details  
- **Core Banking Functions:** Deposit, Withdraw, and Balance Check  
- **Personalized Ads** displayed based on user age  
- **Custom Exception Handling** for invalid transactions  
- **Simple AWT GUI** with clean and minimal design  

---

## 🏗️ System Architecture  

The project is divided into multiple packages to maintain modularity and organization:  
- `main` → Entry point of the application (`Main.java`)  
- `gui` → Frames for Login, KYC, and Main Dashboard  
- `model` → Classes for Account and KYC details  
- `services` → Logic for account management, transactions, and advertisements  
- `utils` → Helper classes like `OTPGenerator`  
- `exceptions` → Custom exception `InsufficientBalanceException`  

**Flow of Execution:**  
`LoginFrame → OTP Verification → KYCFrame → MainFrame → Personalized Ads`

---

## 🧩 Technologies Used
- **Programming Language:** Java  
- **GUI Toolkit:** AWT (Abstract Window Toolkit)  
- **Concepts:** OOP (Encapsulation, Abstraction, Modularity)  
- **Libraries:** `java.util.Random` for OTP generation  
- **IDE Used:** IntelliJ IDEA / Eclipse (any preferred Java IDE)  

---

## 🚀 How to Run the Project  

1. Clone this repository:  
   ```bash
   git clone https://github.com/Chronos2110/Simple-Banking-System.git
