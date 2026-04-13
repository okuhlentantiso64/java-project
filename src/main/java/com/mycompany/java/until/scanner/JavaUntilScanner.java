/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.java.until.scanner;

import java.util.Scanner;

public class JavaUntilScanner {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Login user = new Login();

        // Registration
        System.out.println("=== Register ===");
        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        System.out.print("Enter SA cell (+27...): ");
        String cell = input.nextLine();

        String registerMessage = user.registerUser(username, password, cell);
        System.out.println(registerMessage);

        // Login
        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUser = input.nextLine();

        System.out.print("Enter password: ");
        String loginPass = input.nextLine();

        boolean loginStatus = user.loginUser(loginUser, loginPass);
        System.out.println(user.returnLoginStatus(loginStatus));
    }
}