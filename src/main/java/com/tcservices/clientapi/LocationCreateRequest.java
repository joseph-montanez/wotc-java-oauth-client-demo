package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationCreateRequest {
    public Location location;
}
