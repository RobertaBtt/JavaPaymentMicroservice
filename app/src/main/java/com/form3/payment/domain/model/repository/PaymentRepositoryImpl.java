package com.form3.payment.domain.model.repository;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.data.config.JSONPaymentsConfig;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentRepositoryImpl extends ResourceRepositoryBase<Payment, String> {


    JSONPaymentsConfig jsonPaymentsConfig = new JSONPaymentsConfig();

    private Map<String, Payment> payments = new HashMap<>();

    private List<Payment> paymentList;

    public PaymentRepositoryImpl() {

        super(Payment.class);

        paymentList = jsonPaymentsConfig.getPaymentsFromFile();
        for (Payment payemnt : paymentList) {
            payments.put(payemnt.getId(), payemnt);

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


//    @Override
//    public Class<Payment> getResourceClass() {
//        return null;
//    }
//
//    @Override
//    public Payment findOne(String s, QuerySpec querySpec) {
//         //return querySpec.apply(payments.values());;
//        return new Payment();
//    }
//
//    @Override
//    public synchronized ResourceList<Payment> findAll(QuerySpec querySpec) {
//        return querySpec.apply(payments.values());
//    }
//
//    @Override
//    public ResourceList<Payment> findAll(Iterable<String> iterable, QuerySpec querySpec) {
//        return querySpec.apply(payments.values());
//    }
//
//    @Override
//    public <S extends Payment> S create(S resource) {
//        payments.put(resource.getId(), resource);
//        return resource;
//    }
//
//    @Override
//    public void delete(String id) {
//        payments.remove(id);
//    }
//
//    @Override
//    public <S extends Payment> S save(S resource) {
//        payments.put(resource.getId(), resource);
//        return resource;
//    }
//}
