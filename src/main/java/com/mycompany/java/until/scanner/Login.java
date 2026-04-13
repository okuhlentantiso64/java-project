/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.java.until.scanner;

public class Login {

    private String username;
    private String password;
    private String cellPhone;

    public Login() {
    }

    // Username check
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Password check
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // Phone check
    public boolean checkCellPhoneNumber(String number) {
        return number.matches("^\\+27\\d{9}$");
    }

    // Register
    public String registerUser(String username, String password, String cellPhone) {

        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.username = username;
        this.password = password;
        this.cellPhone = cellPhone;

        return "User successfully registered.";
    }

    // Login
    public boolean loginUser(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Status
    public String returnLoginStatus(boolean loginSuccess) {
        if (loginSuccess) {
            return "Welcome user, it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
