package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("BeneficiaryParty")
public class BeneficiaryParty {

    @JsonProperty("account_name")
    private String accountName;

    @Id
    private String id;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_number_code")
    private String accountNumberCode;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bank_id")
    private String bankId;


    @JsonProperty("bank_id_code")
    private String bankIdCode;

    @JsonProperty("name")
    private String name;

    public BeneficiaryParty() {
        super();
    }
}
