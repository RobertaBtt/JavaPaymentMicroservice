package com.form3.payment.domain.model.repository;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.persistence.config.JSONPaymentsConfig;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentRepository extends ResourceRepositoryBase<Payment, String> {

    @Autowired
    private static Environment env;

    JSONPaymentsConfig jsonPaymentsConfig = new JSONPaymentsConfig();

    private Map<String, Payment> payments = new HashMap<>();

    private List<Payment> paymentList;

    public PaymentRepository() {

        super(Payment.class);

        paymentList = jsonPaymentsConfig.getPaymentsFromFile();
        for (Payment payment : paymentList) {
            payments.put(payment.getId(), payment);

        }
    }


    @Override
    public synchronized ResourceList<Payment> findAll(QuerySpec querySpec) {
        return querySpec.apply(payments.values());
    }

    @Override
    public <S extends Payment> S create(S resource) {

        return this.save(resource);
    }

    @Override
    public void delete(String id) {
        payments.remove(id);
    }

    @Override
    public <S extends Payment> S save(S resource) {
        payments.put(resource.getId(), resource);
        return resource;
    }
}

