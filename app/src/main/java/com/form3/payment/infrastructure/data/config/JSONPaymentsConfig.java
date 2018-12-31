package com.form3.payment.infrastructure.data.config;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.data.JSONPaymentsImporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class JSONPaymentsConfig {

    @Value("${json.folder}")
    private String dataFolder;


    @Bean
    public List<Payment> getPaymentsFromFile() {

        List<Payment> payments = new ArrayList<Payment>();
        JSONPaymentsImporter jsonPaymentsImporter = new JSONPaymentsImporter();

        jsonPaymentsImporter.loadDataFile(payments, dataFolder);


        return payments;

    }
}
