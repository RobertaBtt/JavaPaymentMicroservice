package com.form3.payment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.BeforeClass;
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

    private String type = "Payment";
    private int numberOfPayments = 2;
    private int firstLevelAttributes = 4;

    String paymentId = "216d4da9-e59a-4cc6-8df3-3da6e7580b77";
    String bankIdCodeValue = "GBDSC";
    String accountNumberValue = "GB29XABC10161234567801";

    private String bankIdValue = "854445";
    private String accountNameValue = "Jack Black 0909";
    private String nameValue = "Emily Bronte" ;
    String paymentIdToAdd = "00001";


    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = RestAssured.baseURI.concat(":8080/api/Payment");
    }

    @Test
    public void test_get() {

        RequestSpecification request = RestAssured.given();
        Response response = request.get();

        given()
                .when()
                .get()
                .then()
                .statusCode(200)
                .header("Content-Type", "application/vnd.api+json;charset=UTF-8");

        checkFirstPayment(response);
    }


    private void checkFirstPayment(Response response){


        ArrayList<HashMap<String, String>> dataHashMap = response.jsonPath().get("data");
        HashMap<String, String> firstPayment = dataHashMap.get(0);

        assert dataHashMap.size() == numberOfPayments;
        assert firstPayment.size() == firstLevelAttributes;
        assert firstPayment.get("type").equals(type);
        assert firstPayment.get("id").equals(paymentId);

        Object attributes = firstPayment.get("attributes");
        Object debtorParty = ((HashMap<String, Object>) attributes).get("debtor_party");
        Object bankIdCode = ((HashMap) debtorParty).get("bank_id_code");
        Object accountNumber = ((HashMap) debtorParty).get("account_number");

        assert bankIdCode.equals(bankIdCodeValue);
        assert accountNumber.equals(accountNumberValue);
    }


    @Test
    public void test_post_and_delete() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/vnd.api+json;charset=UTF-8");

        JSONObject jsonObjRequestPost = null;
        try {
            jsonObjRequestPost = new JSONObject("{\n" +
                    "    \"data\": {\n" +
                    "        \"id\": \"" + paymentIdToAdd +"\",\n" +
                    "        \"type\": \"Payment\",\n" +
                    "        \"attributes\": {\n" +
                    "            \"debtor_party\": {\n" +
                    "                \"id\": null,\n" +
                    "                \"account_name\": \"" + accountNameValue +"\",\n" +
                    "                \"account_number\": \"123123123\",\n" +
                    "                \"account_number_code\": \"IBAN\",\n" +
                    "                \"address\": \"1234 Street, NY\",\n" +
                    "                \"bank_id\": \"" + bankIdValue + "\",\n" +
                    "                \"bank_id_code\": \"GBDSC\",\n" +
                    "                \"name\": \"" + nameValue + "\"\n" +
                    "            }\n" +
                    "       }\n" +
                    "   }\n" +
                    "}");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        given()
                .contentType("application/vnd.api+json;charset=UTF-8\"")
                .body(jsonObjRequestPost.toString())
                .when().post("/").then()
                .statusCode(201);

        //Then
        Response responseGetAll = request.get();


        given()
                .contentType("application/vnd.api+json;charset=UTF-8\"")
                .body(jsonObjRequestPost.toString())
                .when().get("/" + paymentIdToAdd).then()
                .statusCode(200);
        //Then
        Response responseGetOne = request.get("/" + paymentIdToAdd);

        checkAddedPayment(responseGetAll, responseGetOne);

    }



    private void checkAddedPayment(Response responseGetAll, Response responseGetOne){

        ArrayList<HashMap<String, String>> dataHashMap = responseGetAll.jsonPath().get("data");
        HashMap<String, String> thirdPayment = dataHashMap.get(2); //The added element is the last

        assert dataHashMap.size() == numberOfPayments +1;
        assert thirdPayment.size() == firstLevelAttributes ;
        assert thirdPayment.get("type").equals(type);
        assert thirdPayment.get("id").equals(paymentIdToAdd);


        HashMap<String, String> addedPaymentHashMap = responseGetOne.jsonPath().get("data");
        assert addedPaymentHashMap.get("id").equals(paymentIdToAdd);


        Object attributes = addedPaymentHashMap.get("attributes");
        Object debtorParty = ((HashMap<String, Object>) attributes).get("debtor_party");
        Object bankId = ((HashMap) debtorParty).get("bank_id");
        Object accountName = ((HashMap) debtorParty).get("account_name");
        Object name = ((HashMap) debtorParty).get("name");

        assert bankId.equals(bankIdValue);
        assert accountName.equals(accountNameValue);
        assert name.equals(nameValue);

    }
}
