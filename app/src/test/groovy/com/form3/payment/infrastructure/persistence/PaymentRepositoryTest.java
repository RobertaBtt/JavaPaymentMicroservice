package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.resource.registry.ResourceRegistry;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PaymentRepositoryTest extends AbstractLiquibaseUnitTest {

    @Autowired
    private ResourceRegistry resourceRegistry;

    private PaymentRepository paymentRepository = new PaymentRepository();

    @Test
    public void payments_not_created() {

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 0;

    }


    @Test
    public void payments_create_one() {

        Payment payment = new Payment("1");
        payment.setId("1");
        paymentRepository.save(payment);

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 1;
        Payment retrievedPayment = paymentRepository.findOne("1", new QuerySpec(Payment.class));
        assert retrievedPayment.getId() == "1";
    }


}