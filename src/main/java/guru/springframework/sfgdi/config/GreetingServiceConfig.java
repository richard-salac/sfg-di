/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guru.springframework.sfgdi.config;

import guru.springframework.pets.DogPetService;
import guru.springframework.pets.PetService;
import guru.springframework.pets.PetServiceFactory;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.repository.EnglishGreetingRepoitoryImpl;
import guru.springframework.sfgdi.repository.EnglishGreetingRepository;
import guru.springframework.sfgdi.services.ConstructorGreetingService;
import guru.springframework.sfgdi.services.I18nEnglishGreetingService;
import guru.springframework.sfgdi.services.I18nSpanishGreetingService;
import guru.springframework.sfgdi.services.PrimaryGreetingService;
import guru.springframework.sfgdi.services.PropertyInjectedGreetingService;
import guru.springframework.sfgdi.services.SetterInjectedGreetingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 *
 * @author Richard Salac (richard.salac@datera.cz)
 */
@PropertySource("classpath:datasource.properties")
@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}") String username,
                                  @Value("${guru.password}") String password,
                                  @Value("${guru.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);

        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }
    
    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(){
        return petServiceFactory().getPetService("dog");
    }
    
    @Profile({"cat","default"})
    @Bean
    PetService catPetService(){
        return petServiceFactory().getPetService("cat");
    }
    
    
    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }
    
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepoitoryImpl();
    }
    
    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    
    @Bean
    @Primary        
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }
    
    //Moved to XML based configuration
    //@Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    
    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }
    
    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
