package com.form3.payment.domain.model;


import io.katharsis.resource.annotations.JsonApiId;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Payment {

    @JsonApiId
    private UUID id;

    private String type;
    private String version;
    private PaymentAttributes attributes;

    public Payment() {
        super();
    }
}
