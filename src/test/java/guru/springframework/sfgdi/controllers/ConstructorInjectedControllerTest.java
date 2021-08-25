/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author R
 */
public class ConstructorInjectedControllerTest {
    
    ConstructorInjectedController controller;
    
    @BeforeEach
    public void setUp() {
        controller = new ConstructorInjectedController(new GreetingServiceImpl());
    }

    /**
     * Test of getGreeting method, of class ConstructorInjectedController.
     */
    @Test
    public void testGetGreeting() {
        System.out.println(controller.getGreeting());
    }
    
}
