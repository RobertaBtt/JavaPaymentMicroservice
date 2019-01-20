package com.form3.payment.domain.model.repository;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import io.katharsis.queryspec.FilterOperator;
import io.katharsis.queryspec.FilterSpec;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.resource.list.ResourceList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PaymentRepoHashMapTest extends AbstractLiquibaseUnitTest {


    private static String paymentId = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
    private static String newPaymentId = "00000000-0000-0000-0000-dd5b6165ec43";

    private PaymentRepoHashMap paymentRepository = new PaymentRepoHashMap();

    private List<Payment> payments; //= paymentRepository.findAll(new QuerySpec(Payment.class));

    @Before
    public void setPaymentList() {
        payments = paymentRepository.findAll(new QuerySpec(Payment.class));

    }

    @Test
    public void payments_loaded_test() {
        assert payments.size() == 2;
    }

    @Test
    public void payment_id_found_test() {

        QuerySpec querySpec = new QuerySpec(Payment.class);
        querySpec.addFilter(new FilterSpec(Arrays.asList("id"), FilterOperator.EQ, paymentId));

        ResourceList<Payment> retrievedPayment = paymentRepository.findAll(querySpec);
        assert retrievedPayment.get(0).getId().equalsIgnoreCase(paymentId);
        assert retrievedPayment.get(0).getCharges_information().getBearerCode().equals("SHAR");
    }

    @Test
    public void payments_create_one_test() {

        //List<Payment> paymentsLocal = payments;
        assert payments.size() == 2;

        Payment payment = new Payment(newPaymentId);
        payment.setAmount("99.99");
        paymentRepository.create(payment);


        QuerySpec querySpec = new QuerySpec(Payment.class);
        querySpec.addFilter(new FilterSpec(Arrays.asList("id"), FilterOperator.EQ, newPaymentId));

        ResourceList<Payment> retrievedPayment = paymentRepository.findAll(querySpec);
        assert retrievedPayment.get(0).getId().equalsIgnoreCase(newPaymentId);
        assert retrievedPayment.get(0).getAmount().equals("99.99");

        //payments = paymentsLocal;
    }


    @Test
    public void payments_remove_one_test() {

//        List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));
//        assert payments.size() == 2;

        paymentRepository.delete(paymentId);

        payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        assert payments.size() == 1;

    }


    @Test
    public void payments_modify_one_test() {

        //List<Payment> payments = paymentRepository.findAll(new QuerySpec(Payment.class));

        //id 4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43
        Payment retrievedPayment = payments.get(0);
        assert retrievedPayment.getBeneficiary_party().getName().equals("Wilfred Jeremiah Owens");

        retrievedPayment.getBeneficiary_party().setName("Roby");
        retrievedPayment.getBeneficiary_party().setAccountName("Roby Owen");

        paymentRepository.save(retrievedPayment);

        payments = paymentRepository.findAll(new QuerySpec(Payment.class));
        retrievedPayment = payments.get(0);
        assert retrievedPayment.getBeneficiary_party().getName().equals("Roby");
        assert retrievedPayment.getBeneficiary_party().getAccountName().equals("Roby Owen");


    }

}