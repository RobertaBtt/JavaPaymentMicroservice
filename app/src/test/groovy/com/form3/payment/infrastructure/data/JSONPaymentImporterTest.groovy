package com.form3.payment.infrastructure.data

import com.form3.payment.domain.model.Payment
import org.junit.Test
import org.springframework.context.annotation.Configuration

@Configuration
class JSONPaymentImporterTest {

    def properties = new Properties()
    def payments = new ArrayList<Payment>();

    @Test
    public void paymentsNumberTest() {

        this.getClass().getResource('/application.properties').withInputStream {
            properties.load(it)
        }

        JSONPaymentsImporter importer = new JSONPaymentsImporter();

        String folder = properties."json.folder";

        importer.loadDataFile(payments, folder);

        assert payments.size() == 2
//        assert payments.first().type == "Payment"
//        assert payments.first().version == "0";
        assert payments.first().amount == "100.21"
 //       assert payments.last().organisation_id.organisation_id == "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb";
    }


}
