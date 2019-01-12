package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.domain.model.repository.PaymentRepositoryImpl;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.FilterOperator;
import io.katharsis.queryspec.FilterSpec;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.resource.list.ResourceList;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PaymentRepositoryTest extends AbstractLiquibaseUnitTest {


    private static String paymentId = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
    private static String newPaymentId = "00000000-0000-0000-0000-dd5b6165ec43";

    private KatharsisClient katharsisClient =
            new KatharsisClient("http://localhost:8080/api");

    //private ResourceRepositoryV2<Payment, Serializable> resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);

    private PaymentRepositoryImpl paymentRepository = new PaymentRepositoryImpl();

    @Test
    public void payments_loaded() {

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 2;

    }

    @Test
    public void payment_id_found() {

        QuerySpec querySpec = new QuerySpec(Payment.class);
        querySpec.addFilter(new FilterSpec(Arrays.asList("id"), FilterOperator.EQ, paymentId));

        ResourceList<Payment> retrievedPayment = paymentRepository.findAll(querySpec);
        assert retrievedPayment.get(0).getId().equalsIgnoreCase(paymentId);
    }

    @Test
    public void payments_create_one_test() {

        Payment payment = new Payment(newPaymentId);
        paymentRepository.create(payment);

        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 3;
        QuerySpec querySpec = new QuerySpec(Payment.class);
        querySpec.addFilter(new FilterSpec(Arrays.asList("id"), FilterOperator.EQ, newPaymentId));

        ResourceList<Payment> retrievedPayment = paymentRepository.findAll(querySpec);
        assert retrievedPayment.get(0).getId().equalsIgnoreCase(newPaymentId);
    }


}