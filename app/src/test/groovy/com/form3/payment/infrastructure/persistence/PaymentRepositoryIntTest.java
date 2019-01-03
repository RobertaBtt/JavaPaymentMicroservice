package com.form3.payment.infrastructure.persistence;

import com.form3.payment.domain.model.Payment;
import com.form3.payment.infrastructure.AbstractLiquibaseUnitTest;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import io.katharsis.queryspec.QuerySpec;
import org.junit.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PaymentRepositoryIntTest extends AbstractLiquibaseUnitTest {

//    @Autowired
//    private ResourceRegistry resourceRegistry;

    @Inject
    private PaymentRepositoryInt paymentRepository;

    @Test
    public void payments_not_created() {
//
//        List<Payment> payments = paymentRepository.findAll();
//        assert payments.size() == 0;

    }



}