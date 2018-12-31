package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("SponsorParty")
public class SponsorParty {

    @Id
    private String id;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("bank_id")
    private String bankId;

    @JsonProperty("bank_id_code")
    private String bankIdCode;


    public SponsorParty() {
        super();
    }
}
