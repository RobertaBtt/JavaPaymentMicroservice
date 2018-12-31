package com.form3.payment.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.form3.payment.domain.annotations.Organisation;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Type("Payment")
public class Payment {

    @Id
    private String id;

    private String version;

    @Organisation
    private String organisation_id;

    @JsonProperty("amount")
    private String amount;

    @Relationship("BeneficiaryParty")
    private BeneficiaryParty beneficiary_party;

    @Relationship("ChargesInformation")
    private ChargesInformation charges_information;

    @JsonProperty("currency")
    private String currency;

    @Relationship("DebtorParty")
    private DebtorParty debtor_party;

    @JsonProperty("end_to_end_reference")
    private String endToEndReference;

    @Relationship("fx")
    private Fx fx;

    @JsonProperty("numeric_reference")
    private String numericReference;

    @JsonProperty("payment_id")
    private String paymentId;

    @JsonProperty("payment_purpose")
    private String paymentPurpose;

    @JsonProperty("payment_scheme")
    private String paymentScheme;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("processing_date")
    private String processingDate;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("scheme_payment_sub_type")
    private String schemePaymentSub_type;

    @JsonProperty("scheme_payment_type")
    private String schemePaymentType;

    @Relationship("SponsorParty")
    private SponsorParty sponsor_party;


    public Payment() {
        super();
    }
}
