package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public Integer id;
    public Integer company_id;
    public String name;
    public String email;
    public String created_at;
    public String updated_at;

    @JsonCreator
    public User(
            @JsonProperty("id") Integer id,
            @JsonProperty("company_id") Integer company_id,
            @JsonProperty("name") String name,
            @JsonProperty("email") String email,
            @JsonProperty("created_at") String created_at,
            @JsonProperty("updated_at") String updated_at
    ) {
        this.id = id;
        this.company_id = company_id;
        this.name = name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
