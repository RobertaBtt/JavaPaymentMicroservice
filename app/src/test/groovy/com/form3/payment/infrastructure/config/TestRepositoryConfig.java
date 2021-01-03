package com.form3.payment.infrastructure.config;

import com.form3.payment.infrastructure.persistence.config.RepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("test.properties")
@EnableTransactionManagement
@Import(RepositoryConfig.class)
public class TestRepositoryConfig {
}
