package com.mycompany.poepart3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PROG5121 POE Part 3 — Full Automated Verification Script.
 */
public class Poepart3Test { 

    private Poepart3 manager; // Fixed: References the uppercase class symbol cleanly

    @BeforeEach
    public void setUp() {
        manager = new Poepart3(100);
        
        manager.addMessage("+27834557896", "Did you get the cake?", "Sent");
        manager.addMessage("+27838884567", "Where are you? You are late! I have asked you to be on time.", "Stored");
        manager.addMessage("+27834484567", "Yohoooo, I am at your gate.", "Disregard");
        manager.addMessage("0838884567", "It is dinner time !", "Sent");
        manager.addMessage("+27838884567", "Ok, I am leaving without you.", "Stored");
    }

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        String[] sentDataVector = manager.getSentMessages();
        assertEquals("Did you get the cake?", sentDataVector[0]);
        assertEquals("It is dinner time !", sentDataVector[3]);
        assertNull(sentDataVector[1]); 
    }

    @Test
    public void testDisplayLongestMessage() {
        String targetRequirementMatch = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(targetRequirementMatch, manager.displayLongestMessage());
    }

    @Test
    public void testSearchByMessageID() {
        String expectedValueResponse = "It is dinner time !";
        assertEquals(expectedValueResponse, manager.searchByMessageID("0838884567"));
    }

    @Test
    public void testSearchAllMessagesRegardingRecipient() {
        // Aligned with internal quote formatting rule additions
        String expectedCombinedStringOutput = "\"Where are you? You are late! I have asked you to be on time.\" \"Ok, I am leaving without you.\"";
        assertEquals(expectedCombinedStringOutput, manager.searchByRecipient("+27838884567"));
    }

    @Test
    public void testDeleteMessageUsingHash() {
        String expectedDeletionConfirmationMessageText = "Message: \"Where are you? You are late! I have asked you to be on time.\" successfully deleted.";
        
        String actualExecutionResultReportOutputString = manager.deleteMessageByHash("Test Message 2");
        assertEquals(expectedDeletionConfirmationMessageText, actualExecutionResultReportOutputString);
        
        assertEquals("Ok, I am leaving without you.", manager.displayLongestMessage());
    }

    @Test
    public void testDisplayReport() {
        String operationalSystemReportDataDumpStringOutput = manager.displayReport();
        assertNotNull(operationalSystemReportDataDumpStringOutput);
        assertTrue(operationalSystemReportDataDumpStringOutput.contains("Recipient: +27834557896"));
        assertTrue(operationalSystemReportDataDumpStringOutput.contains("Message: Did you get the cake?"));
    }
}