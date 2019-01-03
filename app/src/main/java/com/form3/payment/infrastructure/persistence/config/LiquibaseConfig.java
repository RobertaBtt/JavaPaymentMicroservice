package com.form3.payment.infrastructure.persistence.config;

import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.exception.LockException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.inject.Inject;
import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    private final Logger log = LoggerFactory.getLogger(LiquibaseConfig.class);

    private DataSource dataSource;
    private Environment env;

    private String liquibaseChangeLog;
    private boolean enabled;
    private boolean dropFirst;
    private boolean exitAtEnd;

    @Inject
    public LiquibaseConfig(DataSource dataSource, Environment env) {
        this.dataSource = dataSource;
        this.env = env;

        initProperties(env);
    }

    private void initProperties(Environment env) {
        enabled = env.getProperty("form3.liquibase.enabled", Boolean.class, Boolean.FALSE);
        log.debug("form3.liquibase.enabled: {}", enabled);

        liquibaseChangeLog = env.getProperty("form3.liquibase.change-log");
        log.debug("form3.liquibase.change-log: {} ", liquibaseChangeLog);

        dropFirst = env.getProperty("form3.liquibase.drop-first", Boolean.class, Boolean.FALSE);
        log.debug("form3.liquibase.drop-first: {}", dropFirst);

        exitAtEnd = env.getProperty("form3.liquibase.exit-at-end", Boolean.class, Boolean.FALSE);
        log.debug("form3.liquibase.exit-at-end: {}", exitAtEnd);

        log.debug("db.url: {}", env.getProperty("db.url"));

    }

    @Bean
    public Liquibase form3Liquibase() {

        log.debug("Starting form3 liquibase");

        Liquibase liquibase = null;
        try {
            Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation
                    (new JdbcConnection(dataSource.getConnection()));
            liquibase = new Liquibase(liquibaseChangeLog, new ClassLoaderResourceAccessor(), db);
            activeIfNeeded(liquibase);
        } catch (Exception e) {
            e.printStackTrace();
            exitIfNeededWith(1);
        }

        exitIfNeededWith(0);
        return liquibase;
    }


    private void activeIfNeeded(Liquibase liquibase) throws LiquibaseException {
        if (enabled) {
            dropAllIfNeeded(liquibase);
            liquibase.update(new Contexts());
        }
    }

    private void dropAllIfNeeded(Liquibase liquibase) throws DatabaseException, LockException {
        if (dropFirst) {
            liquibase.dropAll();
        }
    }

    private void exitIfNeededWith(int value) {
        if (exitAtEnd) {
            System.exit(value);
        }
    }

}
