package com.form3.payment.client;

import com.form3.payment.domain.model.Payment;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
public class PaymentClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentClient.class);


    private KatharsisClient katharsisClient;
            //new KatharsisClient("http://localhost:8080/api");

    private ResourceRepositoryV2<Payment, Serializable> resourceRepositoryV2;
//
//    @PostConstruct
//    public void init() {
//        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);
//    }

    public PaymentClient() {
        katharsisClient =
                new KatharsisClient("localhost:8080/api");
        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);


    }

    public Payment findOne(String id) {
        System.out.println("ROBY    **************************");
//        LOGGER.debug("Find One in Payment Client");
        Payment result = resourceRepositoryV2.findOne(id, new QuerySpec(Payment.class));
        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);


        return result;
    }

    public void findAll(){
        ResourceList<Payment> result = resourceRepositoryV2.findAll(new QuerySpec(Payment.class));
    }

    public Payment createOne(Payment payment) {
        Payment createdPayment = resourceRepositoryV2.create(payment);
        return createdPayment;
        //resourceRepositoryV2.save(payment);

    }
}
