package com.form3.payment.infrastructure;

import com.form3.payment.PaymentApplicationTest;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {LiquibaseAutoConfiguration.class})
@SpringBootTest(classes = {PaymentApplicationTest.class, LiquibaseAutoConfiguration.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractLiquibaseUnitTest extends AbstractDBUnitTest {
}

