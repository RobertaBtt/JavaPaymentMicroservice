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

        JSONPaymentsImporter jsonPaymentsImporter = new JSONPaymentsImporter();

        String currentDir = System.getProperty("user.dir");
        String folderDataTest = currentDir + "/data/"


        JSONPaymentsImporter importer = new JSONPaymentsImporter();

        importer.loadDataFile(payments, folderDataTest);

        assert payments.size() == 14
        assert payments.first().amount == "100.21"
        assert payments.first().beneficiary_party.accountName == "W Owens"
        
    }


}
