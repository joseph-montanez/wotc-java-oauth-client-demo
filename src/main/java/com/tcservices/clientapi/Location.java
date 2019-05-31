package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    public Integer id;
    public Integer company_id;
    public Integer user_id;
    public String name;
    public String label;
    public String code;
    public String phone;
    public String description;
    public String address_street;
    public String address_street2;
    public String address_city;
    public String address_state;
    public String address_county;
    public String address_zipcode;
    public String created_at;
    public String updated_at;

    @JsonCreator
    public Location(
            @JsonProperty("id") Integer id,
            @JsonProperty("company_id") Integer company_id,
            @JsonProperty("user_id") Integer user_id,
            @JsonProperty("name") String name,
            @JsonProperty("label") String label,
            @JsonProperty("code") String code,
            @JsonProperty("phone") String phone,
            @JsonProperty("description") String description,
            @JsonProperty("address_street") String address_street,
            @JsonProperty("address_street2") String address_street2,
            @JsonProperty("address_city") String address_city,
            @JsonProperty("address_state") String address_state,
            @JsonProperty("address_county") String address_county,
            @JsonProperty("address_zipcode") String address_zipcode,
            @JsonProperty("created_at") String created_at,
            @JsonProperty("updated_at") String updated_at
    ) {
        this.id = id;
        this.company_id = company_id;
        this.user_id = user_id;
        this.name = name;
        this.label = label;
        this.code = code;
        this.phone = phone;
        this.description = description;
        this.address_street = address_street;
        this.address_street2 = address_street2;
        this.address_city = address_city;
        this.address_state = address_state;
        this.address_county = address_county;
        this.address_zipcode = address_zipcode;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }


    public Location() {

    }
}
