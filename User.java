// Name: Steven Houser
// Project: Bank on It Part 1
// Date: 03/20/26

import java.util.*;
import java.io.*;

public abstract class User implements HasMenu, Serializable {

    String userName = "";
    String PIN = "";

    // Return the username
    public String getUserName() {
        return this.userName;
    } // end getUserName

    // Set the username
    public void setUserName(String userName) {
        this.userName = userName;
    } // end setUserName

    // Return the PIN
    public String getPIN() {
        return this.PIN;
    } // end getPIN

    // Set the PIN - must be exactly 4 digits
    public void setPIN(String PIN) {
        if (PIN.matches("^\\d{4}$")) {
            this.PIN = PIN;
        } else {
            System.out.println("Invalid PIN. Must be exactly 4 digits. Resetting to 0000.");
            this.PIN = "0000";
        } // end if
    } // end setPIN

    // Login using provided username and PIN
    public boolean login(String userNameIn, String pinIn) {
        if (!userNameIn.equals(this.userName)) {
            System.out.println("Incorrect username.");
            return false;
        } else if (!pinIn.equals(this.PIN)) {
            System.out.println("Incorrect PIN.");
            return false;
        } else {
            System.out.println("Login Successful");
            return true;
        } // end if
    } // end login

    // Login interactively - prompts user for credentials
    public boolean login() {
        Scanner input = new Scanner(System.in);
        System.out.print("User name: ");
        String userNameIn = input.nextLine();
        System.out.print("PIN: ");
        String pinIn = input.nextLine();
        return login(userNameIn, pinIn);
    } // end login

    // Return a report string for this user
    public abstract String getReport();

} // end class def
