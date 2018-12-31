package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("SenderCharges")
public class SenderCharges {

    @Id
    private String id;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("currency")
    private String currency;

    public SenderCharges() {
        super();
    }
}
