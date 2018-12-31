package com.form3.payment.domain.ResourceHandlers;

public class StringOrganisationIdHandler implements ResourceOrganisationIdHandler {
    public StringOrganisationIdHandler() {
    }

    public String asString(Object identifier) {
        return identifier != null ? String.valueOf(identifier) : null;
    }

    public String fromString(String source) {
        return source;
    }
}
