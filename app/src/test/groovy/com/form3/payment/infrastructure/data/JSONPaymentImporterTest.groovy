package com.form3.payment.infrastructure.data

import com.form3.payment.domain.model.Payment
import com.form3.payment.infrastructure.persistence.repository.BaseRepositoryImpl
import org.junit.Test
import org.springframework.context.annotation.Configuration

import javax.inject.Inject

@Configuration
class JSONPaymentImporterTest {

    def properties = new Properties()
    def payments = new ArrayList<Payment>();

    @Inject
    BaseRepositoryImpl repository;

    @Test
    public void paymentsNumberTest() {

        this.getClass().getResource('/application.properties').withInputStream {
            properties.load(it)
        }

        JSONPaymentsImporter importer = new JSONPaymentsImporter();

        String folder = properties."json.folder";

        importer.loadDataFile(payments, folder);

        assert payments.size() == 2
        assert payments.first().amount == "100.21"
        assert payments.first().beneficiary_party.accountName == "W Owens"
    }


}
