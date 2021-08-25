/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author R
 */
public class PropertyInjectedControllerTest {
    
    PropertyInjectedController controller;
    
    @BeforeEach
    void setup(){
        controller = new PropertyInjectedController();
        controller.greetingService = new ConstructorGreetingService();
    }
    
    /**
     * Test of getGreeting method, of class PropertyInjectedController.
     */
    @Test
    public void testGetGreeting() {
        
        System.out.println(controller.getGreeting());
        
    }
    
}
