package com.form3.payment.domain.model;

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
