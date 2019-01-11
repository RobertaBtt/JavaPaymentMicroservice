package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.domain.model.repository.PaymentRepositoryImpl;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

import java.io.Serializable;
import java.util.List;

public class PaymentRepositoryTest {

//    @Autowired
//    private ResourceRegistry resourceRegistry;


    private KatharsisClient katharsisClient =
            new KatharsisClient("http://localhost:8080/api");

    //private ResourceRepositoryV2<Payment, Serializable> resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);

    private PaymentRepositoryImpl paymentRepository = new PaymentRepositoryImpl();

    @Test
    public void payments_not_created() {

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 0;

    }


    @Test
    public void payments_create_one_test() {

        Payment payment = new Payment("1");
        payment.setId("1");
        paymentRepository.create(payment);

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 1;
        Payment retrievedPayment = paymentRepository.findOne("1", new QuerySpec(Payment.class));
        assert retrievedPayment.getId() == "1";
    }


}