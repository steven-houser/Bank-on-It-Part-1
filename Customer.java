// Name: Steven Houser
// Project: Bank on It Part 1
// Date: 03/20/26

import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable {

    CheckingAccount checking = new CheckingAccount();
    SavingsAccount savings = new SavingsAccount();
    static long serialVersionUID = 1L;

    public static void main(String[] args) {
        Customer c = new Customer();
        boolean loggedIn = c.login();
        if (loggedIn) {
            c.start();
        } // end if
    } // end main

    // Default constructor - sets up test user Alice
    public Customer() {
        this.userName = "Alice";
        this.PIN = "0000";
    } // end constructor

    // Constructor with username and PIN
    public Customer(String userName, String PIN) {
        this.userName = userName;
        this.PIN = PIN;
    } // end constructor

    // Display the customer menu and return user choice
    public String menu() {
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Customer Menu");
        System.out.println();
        System.out.println("0) Exit");
        System.out.println("1) Manage Checking Account");
        System.out.println("2) Manage Savings Account");
        System.out.println("3) Change PIN");
        System.out.println();
        System.out.print("Action (0-3): ");
        String response = input.nextLine();
        return response;
    } // end menu

    // Run the customer menu loop
    public void start() {
        boolean keepGoing = true;
        while (keepGoing) {
            String response = menu();
            if (response.equals("0")) {
                keepGoing = false;
            } else if (response.equals("1")) {
                System.out.println("Checking Account");
                this.checking.start();
            } else if (response.equals("2")) {
                System.out.println("Savings Account");
                this.savings.start();
            } else if (response.equals("3")) {
                changePin();
            } else {
                System.out.println("Please enter 0-3.");
            } // end if
        } // end while
    } // end start

    // Prompt for a new PIN and update it
    public void changePin() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new PIN: ");
        String newPin = input.nextLine();
        setPIN(newPin);
    } // end changePin

    // Return a formatted report for this customer
    public String getReport() {
        return "Customer: " + userName + "\n" +
               "  Checking: " + checking.getBalanceString() + "\n" +
               "  Savings:  " + savings.getBalanceString();
    } // end getReport

} // end class def
