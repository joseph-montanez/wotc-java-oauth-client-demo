package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FormWotc {
    public Integer company_id;
    public Integer location_id;
    public Boolean force_new;
    public Wotc form;
}
