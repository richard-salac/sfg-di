package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfiguration;
import guru.springframework.sfgdi.config.SfgConstructorConfig;
import guru.springframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;
import guru.springframework.sfgdi.controllers.PetController;
import guru.springframework.sfgdi.controllers.PropertyInjectedController;
import guru.springframework.sfgdi.controllers.SetterInjectedController;

import java.util.stream.Stream;

import guru.springframework.sfgdi.datasource.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.sfgdi", "guru.springframework.pets"})
public class SfgDiApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

        //Stream.of(ctx.getBeanDefinitionNames()).sorted().forEach(System.out::println);

        PetController petController = ctx.getBean("petController", PetController.class);
        System.out.println("--- The Best Pet is ---");
        System.out.println(petController.whichPetIsTheBest());

        I18nController i18nController = (I18nController) ctx.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        System.out.println("------------ Primary");

        MyController myController = (MyController) ctx.getBean("myController");

        System.out.println(myController.sayHello());

        System.out.println("------------ Property");

        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("------------ Setter");

        SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

        System.out.println(setterInjectedController.getGreeting());

        System.out.println("------------ Constructor");

        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

        System.out.println(constructorInjectedController.getGreeting());

        FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
        System.out.println(fakeDataSource.getUsername());
        System.out.println(fakeDataSource.getPassword());
        System.out.println(fakeDataSource.getJdbcurl());

        System.out.println("--------------------------Config Props Bean");
        SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
        System.out.println(sfgConfiguration.getUsername());
        System.out.println(sfgConfiguration.getPassword());
        System.out.println(sfgConfiguration.getJdbcurl());

        System.out.println("--------------------------Constructor Binding");
        SfgConstructorConfig sfgConstructorConfig = ctx.getBean(SfgConstructorConfig.class);
        System.out.println(sfgConstructorConfig.getUsername());
        System.out.println(sfgConstructorConfig.getPassword());
        System.out.println(sfgConstructorConfig.getJdbcurl());

    }
}
