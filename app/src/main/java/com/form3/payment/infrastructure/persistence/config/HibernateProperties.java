package com.form3.payment.infrastructure.persistence.config;


interface HibernateProperties {

    String DIALECT = "hibernate.dialect";
    String SHOW_SQL = "hibernate.show_sql";
    String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    String PACKAGES_TO_SCAN = "hibernate.packagesToScan";


}
