package com.form3.payment.domain.model.repository;

import com.form3.payment.domain.model.Payment;
import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryBase;
import io.katharsis.resource.list.ResourceList;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentRepositoryImpl extends ResourceRepositoryBase<Payment, String> {

  private Map<Long, Payment> greetings = new HashMap<>();

  public PaymentRepositoryImpl() {
    super(Payment.class);

    greetings.put(1L, new Payment("1"));
  }

  @Override
  public synchronized ResourceList<Payment> findAll(QuerySpec querySpec) {
    return querySpec.apply(greetings.values());
  }
}
