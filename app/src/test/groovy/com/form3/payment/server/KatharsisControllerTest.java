package com.form3.payment.server;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import wiremock.org.apache.http.client.HttpClient;
import wiremock.org.apache.http.impl.client.DefaultHttpClient;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class KatharsisControllerTest {

    private static WireMockServer mockedServer;
    private static HttpClient client;
    private static RestTemplate restTemplate;

    @BeforeClass
    public static void setUpClass() {

        mockedServer = new WireMockServer();
        mockedServer.start();
        client = new DefaultHttpClient();
        restTemplate = new RestTemplate();

    }

    @AfterClass
    public static void tearDown() {
        mockedServer.stop();
    }

    @Test
    public void test_get_mock() {


        stubFor(get(urlEqualTo("/api/Payment"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/vnd.api+json;charset=UTF-8")
                        .withStatus(200)
                        .withBody("{\"data\":[{\"id\":\"216d4da9-e59a-4cc6-8df3-3da6e7580b77}]}\"")

                ));


        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/Payment",
                String.class
        );

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        response.getHeaders().getContentType().getType().equals("application");
        response.getHeaders().getContentType().getSubtype().equals("vnd.api+json");

        assertThat(response.getBody())
                .isEqualTo("{\"data\":[{\"id\":\"216d4da9-e59a-4cc6-8df3-3da6e7580b77}]}\"");


    }


}
