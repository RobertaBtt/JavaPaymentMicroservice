package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("DebtorParty")
public class DebtorParty {

    @Id
    private String id;

    @JsonProperty("account_name")
    private String accountName;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_number_code")
    private String accountNumberCode;

    @JsonProperty("address")
    private String address;

    @JsonProperty("bank_id")
    private String bankId;

    @JsonProperty("bank_id_code")
    private String bankIdCode;

    @JsonProperty("name")
    private String name;

    public DebtorParty() {
        super();
    }
}
