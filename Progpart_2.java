/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.progpart_2;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Progpart_2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login user = new Login();

        // Registration
        System.out.println("=== Register ===");
        
        System.out.println("Enter FirstName: ");
        String firstName = input.nextLine();
        
        System.out.println("Enter LastName: ");
        String lastName = input.nextLine();
        
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
        
        System.out.println("Welcome to QuickChat.");
        System.out.print("How many messages do you wish to enter? ");
        int maxMessages = input.nextInt();
        input.nextLine(); // clear buffer
        
        Message[] messageStorage = new Message[maxMessages];
        int currentMessageIndex = 0;
        
        while (currentMessageIndex < maxMessages) {
            System.out.println("\n--- Capturing Message " + (currentMessageIndex + 1) + " of " + maxMessages + " ---");
            
            System.out.print("Enter Recipient Cell Number: ");
            String recipient = input.nextLine();
            
            System.out.print("Enter your message text: ");
            String text = input.nextLine();
            
            // Instantiating with the 3 required fields
            Message tempMessage = new Message(currentMessageIndex, recipient, text);
            
            // Step A: Validate length constraints
            String lengthValidationResult = tempMessage.checkMessageLength();
            System.out.println(lengthValidationResult);
            
            if (lengthValidationResult.contains("exceeds")) {
                System.out.println("Input Rejected! Please try re-entering this message correctly.");
                continue; 
            }
            
            // Step B: Validate recipient mobile criteria
            String cellValidationResult = tempMessage.checkRecipientCell();
            System.out.println(cellValidationResult);
            if (cellValidationResult.contains("incorrectly formatted")) {
                System.out.println("Input Rejected! Please try again.");
                continue;
            }
            
            // Step C: Menu Options
            System.out.println("\nSelect an action for this message:");
            System.out.println("1) Send Message\n2) Disregard Message\n3) Store Message");
            System.out.print("Choice: ");
            int menuChoice = input.nextInt();
            input.nextLine(); // clear buffer
            
            System.out.println(tempMessage.SentMessage(menuChoice));
            
            // Step D: Print full summary layout
            System.out.println("\n--- Final Summary Details ---");
            System.out.println(tempMessage.printMessages());
            
            messageStorage[currentMessageIndex] = tempMessage;
            currentMessageIndex++;
        }
        
        System.out.println("\nAll tasks completed successfully!");
    }
}
