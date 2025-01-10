Personal Finance Manager
Overview
The Personal Finance Manager is a web-based application that helps users manage their income, expenses, savings goals, and generate financial reports. It allows users to register, log in, and track transactions with categories, set savings goals, and visualize spending patterns.

Features:
User Management: Register and log in with unique profiles.
Transaction Management: Add, view, update, and delete financial transactions.
Category Management: Create and manage transaction categories.
Savings Goals: Set and track progress towards savings goals.
Reports: Generate monthly and yearly reports with visual charts.
Data Persistence: Data stored in a MySQL database.
Technologies Used:
Java (Servlets, JDBC)
MySQL (Database)
HTML, CSS, JavaScript (Frontend)
Apache Tomcat (Servlet container)
Maven (Dependency management)
Setup Instructions:
Clone the Repository:

bash
Copy code
git clone https://github.com/your-username/finance-manager.git
Import into Eclipse:

Use File -> Import -> Existing Maven Projects.
Select the cloned project directory.
Configure MySQL Database:

Create a MySQL database finance_manager.
Import tables for users, transactions, and categories.
Deploy on Apache Tomcat:

Right-click and select Run As -> Run on Server.
Open the application at http://localhost:8080/finance-managerr.
Project Structure:
Backend: Servlets, DAO classes for database interaction.
Frontend: HTML, CSS, and JavaScript for the UI.
Database: MySQL for storing user data and transactions.
How to Use:
Registration: Register with name, email, and password.
Login: Log in with email and password.
Transactions: Add, update, or delete transactions.
Category Management: Manage transaction categories.
Reports: View monthly and yearly financial reports.
