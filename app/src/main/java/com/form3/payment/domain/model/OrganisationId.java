package com.form3.payment.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.annotations.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganisationId {


    private OrganisationId organisation_id;

    public OrganisationId getOrganisationId() {
        return organisation_id;
    }

    public void setOrganisationId(OrganisationId organisation_id) {
        this.organisation_id = organisation_id;
    }

    public OrganisationId() {
        super();
    }
}
