/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpart_2;

import java.util.Random;

/**
 *
 * @author Student
 */
class Message {
     private String messageID;
    private String recipientCell;
    private String messageText;
    private int messageNumber;
    private String status;

    // CONSTRUCTOR: This fixes the "constructor Message cannot be applied to given types" error
    public Message(int messageNumber, String recipientCell, String messageText) {
        this.messageNumber = messageNumber;
        this.recipientCell = recipientCell;
        this.messageText = messageText;
        this.messageID = generateRandomID();
        this.status = "Pending";
    }

    // Helper to generate a random 10-digit ID
    private String generateRandomID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // Fixes the "cannot find symbol: method checkMessageLength()" error
    public String checkMessageLength() {
        if (this.messageText == null || this.messageText.isEmpty()) {
            return "Invalid: Message cannot be empty. Please try again.";
        }
        
        int length = this.messageText.length();
        if (length <= 250) {
            return "Message ready to send.";
        } else {
            int exceededBy = length - 250;
            return "Message exceeds 250 characters by " + exceededBy + "; please reduce the size and try again.";
        }
    }

    // Fixes the "cannot find symbol: method checkRecipientCell()" error
    public String checkRecipientCell() {
        if (this.recipientCell != null && this.recipientCell.startsWith("+") && this.recipientCell.length() > 2) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // Fixes the "cannot find symbol: method printMessages()" error
    public String printMessages() {
        return "Message ID: " + this.messageID + "\n" +
               "Message Hash: " + createMessageHash() + "\n" +
               "Recipient: " + this.recipientCell + "\n" +
               "Message: " + this.messageText;
    }

    // Creates the unique assignment hash string
    public String createMessageHash() {
        String idPrefix = (this.messageID != null && this.messageID.length() >= 2) ? this.messageID.substring(0, 2) : "00";
        String cleanedText = this.messageText.replaceAll("[?!.]", "");
        String[] words = cleanedText.trim().split("\\s+");
        
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        return (idPrefix + ":" + this.messageNumber + ":" + firstWord + lastWord).toUpperCase();
    }

    // Processes sending action changes
    public String SentMessage(int choice) {
        switch (choice) {
            case 1:
                this.status = "Sent";
                return "Message successfully sent.";
            case 2:
                this.status = "Disregarded";
                return "Press 0 to delete the message.";
            case 3:
                this.status = "Stored";
                return "Message successfully stored.";
            default:
                return "Invalid choice selection.";
        }
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public int returnTotalMessages() {
        return this.messageNumber + 1; 
    }

    public void storeMessage() {
        System.out.println("Researching JSON serialization...");
    }

}
