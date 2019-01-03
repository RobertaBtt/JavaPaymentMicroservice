package com.form3.payment;

import com.form3.payment.client.PaymentClient;
import com.form3.payment.domain.model.BeneficiaryParty;
import com.form3.payment.domain.model.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class PaymentApplicationTest {

    private String paymentId = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";

    @Autowired
    PaymentClient paymentClient;

    @Test
    public void testFindOne() {
        Payment payment = paymentClient.findOne(paymentId);

        assertThat(payment.getAmount().equals("100.21"));
        assertThat(payment.getNumericReference().equals("1002001"));
        assertThat(payment.getBeneficiary_party().getAccountName().equals("W Owens"));
        assertThat(payment.getCharges_information().getBearerCode().equals("SHAR"));

        assertThat(payment.getCharges_information().getSender_charges().get(0).getAmount().equals("5.00"));
        assertThat(payment.getCharges_information().getSender_charges().get(0).getAmount().equals("GBP"));

        assertThat(payment.getCharges_information().getSender_charges().get(1).getAmount().equals("10.00"));
        assertThat(payment.getCharges_information().getSender_charges().get(1).getAmount().equals("USD"));


        assertThat(payment.getDebtor_party().getAccountName().equals("EJ Brown Black"));
        assertThat(payment.getDebtor_party().getAccountNumber().equals("GB29XABC10161234567801"));
        assertThat(payment.getFx().getContractReference().equals("FX123"));

    }

    @Test
    public void testCreateOne(){
        Payment payment = new Payment();

        payment.setId("00000000-0000-00000-0000-000000000043");
        payment.setVersion("0");
        payment.setOrganisation_id("00000000-0000-11111-0000-000000000043");


        BeneficiaryParty beneficiaryParty = new BeneficiaryParty();
        beneficiaryParty.setAccountName("Roby B");
        beneficiaryParty.setAccountNumber("8585858");
        beneficiaryParty.setAccountNumberCode("BBAN");


        payment.setBeneficiary_party(beneficiaryParty);


        when:
        paymentClient.createOne(payment);

        Payment retrievedPayment = paymentClient.findOne("00000000-0000-00000-0000-000000000043");
        then:
        assertThat(retrievedPayment.getId().equals("00000000-0000-00000-0000-000000000043"));
        assertThat(retrievedPayment.getBeneficiary_party().getAccountName().equals("Roby B"));
    }


}
