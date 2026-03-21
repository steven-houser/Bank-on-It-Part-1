// Name: Steven Houser
// Project: Bank on It Part 1
// Date: 03/20/26

import java.util.*;
import java.io.*;

public class CheckingAccount implements HasMenu, Serializable {

    double balance = 0D;

    public static void main(String[] args) {
        CheckingAccount ca = new CheckingAccount();
        ca.start();
    } // end main

    // Default constructor
    public CheckingAccount() {
        balance = 0D;
    } // end constructor

    // Constructor with initial balance
    public CheckingAccount(double balance) {
        this.balance = balance;
    } // end constructor

    // Display the account menu and return user choice
    public String menu() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Account menu");
        System.out.println();
        System.out.println("0) Quit");
        System.out.println("1) Check balance");
        System.out.println("2) Make a deposit");
        System.out.println("3) Make a withdrawal");
        System.out.println();
        System.out.print("Please enter 0-3: ");
        String response = input.nextLine();
        return response;
    } // end menu

    // Run the account menu loop
    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            String response = menu();
            if (response.equals("0")) {
                keepGoing = false;
            } else if (response.equals("1")) {
                checkBalance();
            } else if (response.equals("2")) {
                makeDeposit();
            } else if (response.equals("3")) {
                makeWithdrawal();
            } else {
                System.out.println("Please enter 0-3.");
            } // end if
        } // end while
    } // end start

    // Return the current balance
    public double getBalance() {
        return this.balance;
    } // end getBalance

    // Return balance formatted as currency
    public String getBalanceString() {
        return String.format("$%.2f", this.balance);
    } // end getBalanceString

    // Set the balance
    public void setBalance(double balance) {
        this.balance = balance;
    } // end setBalance

    // Print the current balance
    public void checkBalance() {
        System.out.println("Checking balance...");
        System.out.println("Current balance: " + getBalanceString());
    } // end checkBalance

    // Safely read a double from user input
    private double getDouble() {
        Scanner input = new Scanner(System.in);
        String strAmount = input.nextLine();
        double amount = 0D;
        try {
            amount = Double.parseDouble(strAmount);
        } catch (NumberFormatException e) {
            System.out.println("Not a valid amount, changing to zero.");
            amount = 0D;
        } // end try
        return amount;
    } // end getDouble

    // Deposit money into the account
    public void makeDeposit() {
        System.out.println("Making a deposit...");
        System.out.print("How much to deposit? ");
        double amount = getDouble();
        balance += amount;
        System.out.println("New balance: " + getBalanceString());
    } // end makeDeposit

    // Withdraw money from the account
    public void makeWithdrawal() {
        System.out.println("Making a withdrawal...");
        System.out.print("How much to withdraw? ");
        double amount = getDouble();
        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            balance -= amount;
            System.out.println("New balance: " + getBalanceString());
        } // end if
    } // end makeWithdrawal

} // end class def
