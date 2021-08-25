/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.sfgdi.controllers;

import org.springframework.stereotype.Controller;

/**
 *
 * @author R
 */
@Controller
public class MyController {
    
    public String sayHello(){
        System.out.println("Hello world !!!");
        
        return "Hi Folks!";
    }
    
}
