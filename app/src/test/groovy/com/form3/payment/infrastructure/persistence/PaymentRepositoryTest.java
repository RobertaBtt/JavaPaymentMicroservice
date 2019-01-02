package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import io.katharsis.queryspec.QuerySpec;
import org.junit.Test;

import javax.inject.Inject;
import java.util.List;

public class PaymentRepositoryTest extends AbstractLiquibaseUnitTest {


    private PaymentRepository paymentRepository = new PaymentRepository();

    @Test
    public void payments_not_created() {

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 0;

    }


    @Test
    public void payments_create_one() {

        Payment payment = paymentRepository.save(new Payment());
        assert payment != null;

    }


}