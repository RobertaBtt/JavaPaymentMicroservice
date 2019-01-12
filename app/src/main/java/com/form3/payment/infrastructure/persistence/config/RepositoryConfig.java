package com.form3.payment.infrastructure.persistence.config;

import com.form3.payment.domain.model.repository.PaymentRepositoryImpl;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


@Configuration
@EnableJpaRepositories(basePackages = {"com.form3.payment.domain.model",
        "com.form3.payment.infrastructure.persistence"}, repositoryBaseClass = PaymentRepositoryImpl.class)
@EnableTransactionManagement
public class RepositoryConfig {


    private static final Logger logger = LoggerFactory.getLogger(RepositoryConfig.class);

    @Autowired
    private Environment env;


    @Bean
    public DataSource dataSource() {

        logger.warn("datasource db.url: {} db.username: {}", env.getProperty(DatabaseProperties.URL), env.getProperty(DatabaseProperties.USERNAME));

        JdbcDataSource dataSource = new JdbcDataSource();

        dataSource.setURL(env.getProperty(DatabaseProperties.URL));
        dataSource.setUser(env.getProperty(DatabaseProperties.USERNAME));
        dataSource.setPassword(env.getProperty(DatabaseProperties.PASSWORD));

        SLF4JQueryLoggingListener listener = new SLF4JQueryLoggingListener();
        listener.setLogger(LoggerFactory.getLogger(RepositoryConfig.class));
        return ProxyDataSourceBuilder.create(dataSource)
                .listener(listener)
                .countQuery()
                .build();
    }
//
//    /**
//     * Declare the JPA entity manager factory.
//     */
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean entityManagerFactory =
//                new LocalContainerEntityManagerFactoryBean();
//
//        entityManagerFactory.setDataSource(dataSource());
//        entityManagerFactory.setPackagesToScan(env.getProperty(HibernateProperties.PACKAGES_TO_SCAN));
//        entityManagerFactory.setJpaProperties(hibernateProperties());
//
//        // Vendor adapter
//        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
//
//        return entityManagerFactory;
//    }
//
//    private Properties hibernateProperties() {
//        Properties additionalProperties = new Properties();
//        additionalProperties.put(HibernateProperties.DIALECT, env.getProperty(HibernateProperties.DIALECT));
//        additionalProperties.put(HibernateProperties.SHOW_SQL, env.getProperty(HibernateProperties.SHOW_SQL));
//        additionalProperties.put(HibernateProperties.HBM2DDL_AUTO, env.getProperty(HibernateProperties.HBM2DDL_AUTO));
//        return additionalProperties;
//    }
//
//    /**
//     * Declare the transaction manager.
//     */
//    @Bean
//    public JpaTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
//
//    /**
//     * PersistenceExceptionTranslationPostProcessor is a bean post processor
//     * which adds an advisor to any bean annotated with Repository so that any
//     * platform-specific exceptions are caught and then rethrown as one
//     * Spring's unchecked data access exceptions (i.e. a subclass of
//     * DataAccessException).
//     */
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//        return new PersistenceExceptionTranslationPostProcessor();
//    }

}
