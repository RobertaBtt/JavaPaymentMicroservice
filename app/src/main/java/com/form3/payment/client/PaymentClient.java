package com.form3.payment.client;

import com.form3.payment.domain.model.Payment;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PaymentClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(PaymentClient.class);

  private KatharsisClient katharsisClient =
      new KatharsisClient("http://localhost:8080/api");
  private ResourceRepositoryV2<Payment, String> resourceRepositoryV2;

  @PostConstruct
  public void init() {
    resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);
  }

  public Payment findOne(String id) {
    Payment result = resourceRepositoryV2.findOne(id, new QuerySpec(Payment.class));

    LOGGER.info("found {}", result.toString());
    return result;
  }
}
