package com.form3.payment.domain.annotations;

import com.form3.payment.domain.ResourceHandlers.ResourceOrganisationIdHandler;
import com.form3.payment.domain.ResourceHandlers.StringOrganisationIdHandler;
import com.github.jasminb.jsonapi.ResourceIdHandler;
import com.github.jasminb.jsonapi.StringIdHandler;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//
//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface Organisation {
//    Class<? extends ResourceOrganisationIdHandler> value() default StringOrganisationIdHandler.class;
//}
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Organisation {
    Class<? extends ResourceIdHandler> value() default StringIdHandler.class;
}
