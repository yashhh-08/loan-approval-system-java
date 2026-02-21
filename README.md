# Loan Approval System (Full Stack - Java OOP)

# Overview
A full-stack Loan Approval System developed using Java (OOP principles) for backend processing and HTML/CSS/JavaScript for frontend interaction.

The system evaluates loan eligibility based on financial parameters such as:
- Income
- Credit Score
- FOIR (Fixed Obligation to Income Ratio)
- LTV (Loan to Value Ratio)
- EMI-to-Income ratio

# Features
- Multiple Loan Types (Housing, Vehicle, Secured Personal Loan)
- Automated EMI Calculation
- FOIR & LTV Evaluation
- Credit Score Validation
- Approval Probability (High / Medium / Low)
- Clean Frontend UI with Backend Server Processing


# Tech Stack
- Java
- Object-Oriented Programming (OOP)
- HTML
- CSS
- JavaScript

# OOP Concepts Implemented
-  Abstraction (Abstract Loan class)
-  Inheritance (Different Loan Types)
-  Polymorphism (Overridden loan logic)
-  Encapsulation (Protected fields & methods)

-----

# Project Structure

LoanApprovalSystem
│
├── Backend
│   ├── Loan.java
│   ├── HousingLoan.java
│   ├── VehicleLoan.java
│   ├── SecuredPersonalLoan.java
│   ├── LoanApprovalServer.java
│   └── LoanHandler.java
│
├── Frontend
│   ├── index.html
│   ├── style.css
│   └── script.js

# How to Run

# Run Backend
- Navigate to backend folder
- Compile:
  javac *.java
- Run:
  java backend.LoanApprovalServer

# Run Frontend
- Open index.html in browser
- Ensure backend server is running

# Future Improvements
- JSON API responses
- Database integration
- User authentication
- Loan history tracking

# Author
Yash Thorat
