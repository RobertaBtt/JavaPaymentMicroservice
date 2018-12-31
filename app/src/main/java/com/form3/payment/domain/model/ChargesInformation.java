package com.form3.payment.domain.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Type("ChargesInformation")
public class ChargesInformation {


    @Id
    private String id;

    @JsonProperty("bearer_code")
    private String bearerCode;

    @Relationship("sender_charges")
    private List<SenderCharges> sender_charges;

    @JsonProperty("receiver_charges_amount")
    private String receiverChargesAmount;

    @JsonProperty("receiver_charges_currency")
    private String receiverChargesCurrency;


    public ChargesInformation() {
        super();
    }
}
