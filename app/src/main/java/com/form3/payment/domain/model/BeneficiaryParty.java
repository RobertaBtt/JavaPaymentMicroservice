package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import io.katharsis.resource.annotations.JsonApiId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Type("BeneficiaryParty")
@Table(name = "beneficiary_party")
public class BeneficiaryParty {

    @JsonProperty("account_name")
    private String accountName;

    @Id
    @JsonApiId
    @javax.persistence.Id
    @Column(name = "id")
    private String id;

    @JsonProperty("account_number")
    @Column(name = "account_number")
    private String accountNumber;

    @JsonProperty("account_number_code")
    @Column(name = "account_number_code")
    private String accountNumberCode;

    @JsonProperty("account_type")
    @Column(name = "account_type")
    private String accountType;

    @JsonProperty("address")
    @Column(name = "address")
    private String address;

    @JsonProperty("bank_id")
    @Column(name = "bank_id")
    private String bankId;


    @JsonProperty("bank_id_code")
    @Column(name = "bank_id_code")
    private String bankIdCode;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    public BeneficiaryParty() {
        super();
    }
}
