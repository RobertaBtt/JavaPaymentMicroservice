package com.form3.payment.infrastructure;

import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {LiquibaseAutoConfiguration.class})
public abstract class AbstractLiquibaseUnitTest extends AbstractDBUnitTest {
}

