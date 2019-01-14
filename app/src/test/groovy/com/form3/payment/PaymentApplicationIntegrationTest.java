package com.form3.payment;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentApplicationIntegrationTest {

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


        ArrayList<HashMap<String, String>> data = response.jsonPath().get("data");
        HashMap<String, String> firstPayment = data.get(0);


        assert firstPayment.size() == 4;
        //assert firstPayment.get("attributes").size() == 19;

//        String sresponse = get(urlEqualTo("http://localhost:8080/api/Payment")).build()
//                .getResponse().getBody();

    }
}
