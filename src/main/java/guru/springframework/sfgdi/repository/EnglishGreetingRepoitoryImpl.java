/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.sfgdi.repository;

/**
 *
 * @author Richard Salac (richard.salac@datera.cz)
 */
public class EnglishGreetingRepoitoryImpl implements EnglishGreetingRepository{

    @Override
    public String getGreeting() {
        return "Hello World - EN";
    }
    
}
