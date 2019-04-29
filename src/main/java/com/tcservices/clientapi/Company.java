package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    public Integer id;
    public String name;
    public String label;
    public String ein;
    public String address;
    public String address2;
    public String city;
    public String state;
    public String zip;
    public String phone;
    public Boolean for_profit;
    public String website;
    public String comments;
    public String created_at;
    public String updated_at;

    @JsonCreator
    public Company(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("label") String label,
            @JsonProperty("ein") String ein,
            @JsonProperty("address") String address,
            @JsonProperty("address2") String address2,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("zip") String zip,
            @JsonProperty("phone") String phone,
            @JsonProperty("for_profit") Boolean for_profit,
            @JsonProperty("website") String website,
            @JsonProperty("comments") String comments,
            @JsonProperty("created_at") String created_at,
            @JsonProperty("updated_at") String updated_at
    ) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.ein = ein;
        this.address = address;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.for_profit = for_profit;
        this.website = website;
        this.comments = comments;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}