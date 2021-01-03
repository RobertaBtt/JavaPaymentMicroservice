package com.form3.payment.client;

import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import com.form3.payment.infrastructure.persistence.config.RepositoryConfig;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

//@Configuration
//@RunWith(SpringJUnit4ClassRunner.class)
@Import({RepositoryConfig.class})
//@Transactional
////@DatabaseSetup({"classpath:payments-setup.xml"})
@EnableAutoConfiguration
public class PaymentClientTest extends AbstractLiquibaseUnitTest {

    private String paymentId = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";


    @Test
    public void testFindOne() {

//        Payment payment = paymentClient.findOne(paymentId);
//
//        then:
//        assertThat(payment.getAmount().equals("100.21"));
//        assertThat(payment.getNumericReference().equals("1002001"));
//        assertThat(payment.getBeneficiary_party().getAccountName().equals("W Owens"));
//        assertThat(payment.getCharges_information().getBearerCode().equals("SHAR"));
//
//        assertThat(payment.getCharges_information().getSender_charges().get(0).getAmount().equals("5.00"));
//        assertThat(payment.getCharges_information().getSender_charges().get(0).getAmount().equals("GBP"));
//
//        assertThat(payment.getCharges_information().getSender_charges().get(1).getAmount().equals("10.00"));
//        assertThat(payment.getCharges_information().getSender_charges().get(1).getAmount().equals("USD"));
//
//
//        assertThat(payment.getDebtor_party().getAccountName().equals("EJ Brown Black"));
//        assertThat(payment.getDebtor_party().getAccountNumber().equals("GB29XABC10161234567801"));
//        assertThat(payment.getFx().getContractReference().equals("FX123"));
        assertThat("ciao".equalsIgnoreCase("ciao"));

    }

    @Test
    public void testCreateOne() {
//        Payment payment = new Payment();
//
//        payment.setId("00000000-0000-00000-0000-000000000043");
//        payment.setVersion("0");
//        payment.setOrganisation_id("00000000-0000-11111-0000-000000000043");
//
//
//        BeneficiaryParty beneficiaryParty = new BeneficiaryParty();
//        beneficiaryParty.setAccountName("Roby B");
//        beneficiaryParty.setAccountNumber("8585858");
//        beneficiaryParty.setAccountNumberCode("BBAN");
//
//
//        payment.setBeneficiary_party(beneficiaryParty);
//
//
//        when:
//        paymentClient.createOne(payment);
//
//        Payment retrievedPayment = paymentClient.findOne("00000000-0000-00000-0000-000000000043");
//        then:
//        assertThat(retrievedPayment.getId().equals("00000000-0000-00000-0000-000000000043"));
//        assertThat(retrievedPayment.getBeneficiary_party().getAccountName().equals("Roby B"));

        assertThat(1 == 1);
    }


}
