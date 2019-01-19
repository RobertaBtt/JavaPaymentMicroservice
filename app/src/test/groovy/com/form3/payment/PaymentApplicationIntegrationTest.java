package com.form3.payment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@Category(IntegrationTest.class)
public class PaymentApplicationIntegrationTest extends AbstractIntegrationTest {


    @Test
    public void test_get() {


        RestAssured.baseURI = RestAssured.baseURI.concat(":8080/api/Payment");
        RequestSpecification request = RestAssured.given();
        Response response = request.get();


        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .header("Content-Type", "application/vnd.api+json;charset=UTF-8");


        ArrayList<HashMap<String, String>> dataHashMap = response.jsonPath().get("data");

        //There are 2 payments
        assert dataHashMap.size() == 2;
        HashMap<String, String> firstPayment = dataHashMap.get(0);

        //Payment has 4 main elements:
        assert firstPayment.size() == 4;
        assert firstPayment.get("type").equals("Payment");
        assert firstPayment.get("id").equals("216d4da9-e59a-4cc6-8df3-3da6e7580b77");

        Object attributes = firstPayment.get("attributes");
        Object debtorParty = ((HashMap<String, Object>)attributes).get("debtor_party");
        Object bankIdCode = ((HashMap) debtorParty).get("bank_id_code");
        Object accountNumber = ((HashMap) debtorParty).get("account_number");

        assert bankIdCode.equals("GBDSC");
        assert accountNumber.equals("GB29XABC10161234567801");

        attributes.equals(attributes);
    }
}
