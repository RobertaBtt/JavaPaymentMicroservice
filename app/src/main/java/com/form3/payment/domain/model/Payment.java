package com.form3.payment.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.form3.payment.domain.annotations.Organisation;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import io.katharsis.resource.annotations.JsonApiId;
import io.katharsis.resource.annotations.JsonApiResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
@Getter
@Setter
@Type("Payment")
@Table(name = "payment")
@JsonApiResource(type = "Payment")
public class Payment {

    @Id
    @JsonApiId
    @javax.persistence.Id
    @Column(name = "id")
    private String id;

    @Column(name = "version")
    private String version;

    public Payment() {
        super();
    }

    @Organisation
    @Column(name = "organisation_id")
    private String organisation_id;

    @Relationship("BeneficiaryParty")
    //@Column(name = "beneficiary_party")
    private BeneficiaryParty beneficiary_party;

    @Relationship("ChargesInformation")
    @Column(name = "charges_information")
    private ChargesInformation charges_information;

    @JsonProperty("currency")
    @Column(name = "currency")
    private String currency;

    @Relationship("DebtorParty")
    @Column(name = "debtor_party")
    private DebtorParty debtor_party;


    @Relationship("SponsorParty")
    @Column(name = "sponsor_party")
    private SponsorParty sponsor_party;

    @JsonProperty("end_to_end_reference")
    @Column(name = "end_to_end_reference")
    private String endToEndReference;

    @Relationship("fx")
    @Column(name = "fx")
    private Fx fx;


    @JsonProperty("amount")
    @Column(name = "amount")
    private String amount;


    @JsonProperty("numeric_reference")
    @Column(name = "numeric_reference")
    private String numericReference;

    @JsonProperty("payment_id")
    @Column(name = "payment_id")
    private String paymentId;

    @JsonProperty("payment_purpose")
    @Column(name = "payment_purpose")
    private String paymentPurpose;

    @JsonProperty("payment_scheme")
    @Column(name = "payment_scheme")
    private String paymentScheme;

    @JsonProperty("payment_type")
    @Column(name = "payment_type")
    private String paymentType;

    @JsonProperty("processing_date")
    @Column(name = "processing_date")
    private String processingDate;

    @JsonProperty("reference")
    @Column(name = "reference")
    private String reference;

    @JsonProperty("scheme_payment_sub_type")
    @Column(name = "scheme_payment_sub_type")
    private String schemePaymentSub_type;

    @JsonProperty("scheme_payment_type")
    @Column(name = "scheme_payment_type")
    private String schemePaymentType;


    public Payment(String id) {
        this.id = id;
    }
}
