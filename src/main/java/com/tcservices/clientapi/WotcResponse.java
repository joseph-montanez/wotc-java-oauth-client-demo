package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WotcResponse {
    /**
     * The employee ID
     */
    public Integer id;

    /**
     * The list of errors
     */
    public HashMap<String, ArrayList<String>> errors;

    /**
     * If the action was successful
     */
    public boolean success;

    @JsonCreator
    public WotcResponse(
            @JsonProperty("id") Integer id,
            @JsonProperty("errors") HashMap<String, ArrayList<String>> errors
    ) {
        this.id = id;
        this.errors = errors;
    }
}
