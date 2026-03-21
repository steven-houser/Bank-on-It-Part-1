// Name: Steven Houser
// Project: Bank on It Part 1
// Date: 03/20/26

import java.util.*;
import java.io.*;

public class SavingsAccount extends CheckingAccount {

    double interestRate = .05D;

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount();
        sa.start();
    } // end main

    // Set the interest rate
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    } // end setInterestRate

    // Return the interest rate
    public double getInterestRate() {
        return this.interestRate;
    } // end getInterestRate

    // Apply interest to the balance
    public void calcInterest() {
        double interestAmount = balance * interestRate;
        balance += interestAmount;
        System.out.println("Interest applied. New balance: " + getBalanceString());
    } // end calcInterest

} // end class def
