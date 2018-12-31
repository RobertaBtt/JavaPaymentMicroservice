package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("fx")
public class Fx {

    @Id
    private String id;

    @JsonProperty("contract_reference")
    private String contractReference;

    @JsonProperty("exchange_rate")
    private String exchangeRate;

    @JsonProperty("original_amount")
    private String originalAmount;

    @JsonProperty("original_currency")
    private String originalCurrency;

    public Fx() {
        super();
    }
}
