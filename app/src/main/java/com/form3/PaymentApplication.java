package com.form3;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
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

