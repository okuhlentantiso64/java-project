/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.java.until.scanner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author Student
 */
public class LoginTest {

    Login user = new Login();

    // ✅ 1. Username Test
    @Test
    public void testCheckUserName() {
        assertTrue(user.checkUserName("kyl_1"));   // correct
        assertFalse(user.checkUserName("kyle123")); // incorrect
    }

    // ✅ 2. Password Test
    @Test
    public void testCheckPasswordComplexity() {
        assertTrue(user.checkPasswordComplexity("Ch&&sec@ke99!")); // correct
        assertFalse(user.checkPasswordComplexity("password"));     // incorrect
    }

    // ✅ 3. Login Test
    @Test
    public void testLoginUser() {
        user.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");

        assertTrue(user.loginUser("kyl_1", "Ch&&sec@ke99!")); // success
        assertFalse(user.loginUser("wrong", "wrong"));        // fail
    }
}