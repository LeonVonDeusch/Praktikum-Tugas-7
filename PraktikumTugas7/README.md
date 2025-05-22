# 💳 Simple Bank Application in Java

A simple console-based Java application simulating a basic banking system with login, authentication, and withdrawal functionality. Exception handling is implemented for robust error management.

## 📦 Features

- User login with account number and password
- Exception handling for:
  - Invalid account number (`AccountNotFoundException`)
  - Wrong password (`WrongPasswordException`)
  - Insufficient balance (`InsufficientFundsException`)
  - Invalid input (e.g. negative withdrawal)
- Console-based interaction
- Clean and modular code structure

## Exception me use
- Custom Exceptions
  - `AccountNotFoundException`
  - `WrongPasswordException`
  - `InsufficientFundsException`
- Built-in Exceptions
  - `IllegalArgumentsException`
  - `Exception`

## 🧩 File Structure
- BankApp.java # Main application (UI + logic)
- BankAccount.java # Bank account model + login logic
- AccountNotFoundException.java # Custom exception for invalid account
- WrongPasswordException.java # Custom exception for incorrect password
- InsufficientFundsException.java # Custom exception for balance check


## 🏃 How to Run

1. Clone or download this project.
2. Compile all `.java` files:

## Main for the Use
BankApp.java


