package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;

import java.util.HashMap;
import java.util.Map;

public class BackupPaymentRepository extends ResourceRepositoryBase<Payment, String> {


    private Map<String, Payment> payments = new HashMap<>();

    public BackupPaymentRepository() {
        super(Payment.class);
    }

    @Override
    public synchronized void delete(String id) {
        payments.remove(id);
    }

    @Override
    public synchronized <S extends Payment> S save(S payment) {
        payments.put(payment.getId(), payment);
        return payment;
    }

    @Override
    public synchronized ResourceList<Payment> findAll(QuerySpec querySpec) {
        return querySpec.apply(payments.values());
    }


}
