package com.form3.payment.server;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


@RunWith(SpringRunner.class)
//@Import(PaymentApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class KatharsisControllerTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8081); // No-args constructor defaults to port 8080


    @Test
    public void test_get_mock() {

        stubFor(get(urlEqualTo("http://localhost:8081/api/Payment"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/vnd.api+json;charset=UTF-8")
                        .withStatus(200)
                ));


        RestAssured.baseURI = RestAssured.baseURI.concat(":8080/api/Payment");
        RequestSpecification request = RestAssured.given();

    }


}
