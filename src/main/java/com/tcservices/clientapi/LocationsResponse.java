package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationsResponse {
    /**
     * The locations
     */
    public ArrayList<Location> locations;

    /**
     * The list of errors
     */
    public HashMap<String, ArrayList<String>> errors;

    /**
     * If the action was successful
     */
    public boolean success;

    @JsonCreator
    public LocationsResponse(
            @JsonProperty("locations") ArrayList<Location> locations,
            @JsonProperty("errors") HashMap<String, ArrayList<String>> errors
    ) {
        this.locations = locations;
        this.errors = errors;
    }
}
