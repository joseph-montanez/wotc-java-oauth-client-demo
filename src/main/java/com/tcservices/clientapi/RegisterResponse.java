package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterResponse {
    /**
     * The user that registered
     */
    public User user;

    /**
     * The company that registered
     */
    public Company company;

    /**
     * The WOTC 8850 Employee / Applicant URL
     */
    public String wotc_url;

    /**
     * The lifetime access token
     */
    public String token;

    /**
     * The list of errors
     */
    public HashMap<String, ArrayList<String>> errors;

    /**
     * If the action was successful
     */
    public boolean success;

    @JsonCreator
    public RegisterResponse(
            @JsonProperty("user") User user,
            @JsonProperty("company") Company company,
            @JsonProperty("wotc_url") String wotc_url,
            @JsonProperty("token") String token,
            @JsonProperty("errors") HashMap<String, ArrayList<String>> errors
    ) {
        this.user = user;
        this.company = company;
        this.wotc_url = wotc_url;
        this.token = token;
        this.errors = errors;
    }
}
