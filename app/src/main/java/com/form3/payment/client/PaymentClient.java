package com.form3.payment.client;

import com.form3.payment.domain.model.Payment;
import io.katharsis.client.KatharsisClient;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.registry.ResourceRegistry;
import io.katharsis.spring.boot.v3.KatharsisConfigV3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Component
@Import({KatharsisConfigV3.class})
public class PaymentClient {

//    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentClient.class);

    @Autowired
    private ResourceRegistry resourceRegistry;

    @Value("${katharsis.pathPrefix}")
    private String pathPrefix;

    @Value("${katharsis.domainName}")
    private String domainName;

    private KatharsisClient katharsisClient =
            new KatharsisClient("http://localhost:8080/api");

    private ResourceRepositoryV2<Payment, Serializable> resourceRepositoryV2;

    @PostConstruct
    public void init() {
        //resourceRepositoryV2 = new PaymentRepositoryImpl();
        resourceRepositoryV2 = katharsisClient.getRepositoryForType(Payment.class);
    }

    public Payment findOne(String id) {
        System.out.println("ROBY    **************************");
//        LOGGER.debug("Find One in Payment Client");
        Payment result = resourceRepositoryV2.findOne(id, new QuerySpec(Payment.class));

        return result;
    }

    public Payment createOne(Payment payment) {
        Payment createdPayment = resourceRepositoryV2.create(payment);
        return createdPayment;
        //resourceRepositoryV2.save(payment);

    }
}
