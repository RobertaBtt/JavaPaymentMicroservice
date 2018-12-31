package com.form3.payment.domain.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.form3.payment.domain.model"})
@EnableAspectJAutoProxy
public class DomainConfig {
}
