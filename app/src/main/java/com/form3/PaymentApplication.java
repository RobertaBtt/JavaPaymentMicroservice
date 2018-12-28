package com.form3;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {LiquibaseAutoConfiguration.class})
public class PaymentApplication {

    public static void main(String[] args) {

        try {
            SpringApplication.run(PaymentApplication.class, args);
        } catch (BeanCreationException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
