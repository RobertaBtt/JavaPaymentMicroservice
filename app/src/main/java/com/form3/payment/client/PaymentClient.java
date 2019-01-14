package com.form3.payment.client;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.domain.model.repository.PaymentRepositoryImpl;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class PaymentClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentClient.class);


    private KatharsisClient katharsisClient;


    private ResourceRepositoryV2<Payment, Serializable> resourceRepositoryV2;

    private PaymentRepositoryImpl paymentRepository = new PaymentRepositoryImpl();


    public PaymentClient() {
        katharsisClient =
                new KatharsisClient("localhost:8080/api");

        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);


    }

    public Payment findOne(String id) {
        Payment result = resourceRepositoryV2.findOne(id, new QuerySpec(Payment.class));
        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);


        return result;
    }

    public ResourceList<Payment> findAll() {
        return paymentRepository.findAll(new QuerySpec(Payment.class));

        //ResourceList<Payment> result = resourceRepositoryV2.findAll(new QuerySpec(Payment.class));
    }

    public Payment createOne(Payment payment) {
        Payment createdPayment = resourceRepositoryV2.create(payment);
        return createdPayment;
        //resourceRepositoryV2.save(payment);

    }
}
