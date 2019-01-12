package com.form3.payment.infrastructure.data;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.persistence.repository.BaseRepositoryImpl;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;


public class JSONPaymentsImporter {


    @Inject
    BaseRepositoryImpl repository;

    public List<Payment> loadDataFile(List<Payment> payments, String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        byte[] fileContent;
        ResourceConverter converter = new ResourceConverter(Payment.class);

        if (file.isDirectory()) {

            for (File childFile : file.listFiles()) {

                loadDataFile(payments, file.getName() + File.separator + childFile.getName());
            }
        } else {

            try {
                fileContent = Files.readAllBytes(file.toPath());
                payments = convertListPayments(converter, fileContent, payments);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return payments;
    }

    private List<Payment> convertListPayments(ResourceConverter converter, byte[] fileContent, List<Payment> payments) {

        // To convert raw data into collection
        JSONAPIDocument<List<Payment>> paymentJSONCollection = converter.readDocumentCollection(fileContent, Payment.class);
        payments.addAll(paymentJSONCollection.get());
        paymentJSONCollection.getMeta();
        return payments;
    }

    private List<Payment> convertOnePayment(ResourceConverter converter, byte[] fileContent, List<Payment> payments) {

        // To convert raw data into single POJO
        JSONAPIDocument<Payment> paymentJSONSingle = converter.readDocument(fileContent, Payment.class);
        Payment payment = paymentJSONSingle.get();
        payments.add(payment);
        return payments;
    }
}
