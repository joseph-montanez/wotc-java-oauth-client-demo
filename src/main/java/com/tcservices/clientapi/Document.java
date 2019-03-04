package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {
    public Integer id;
    public Integer company_id;
    public Integer employee_id;
    public Integer user_id;
    public String name;
    public String expiration;
    public String document_type;
    public String file_type;
    public Integer file_size;
    public String created_at;
    public String updated_at;

    @JsonCreator
    public Document(
            @JsonProperty("id") Integer id,
            @JsonProperty("company_id") Integer company_id,
            @JsonProperty("employee_id") Integer employee_id,
            @JsonProperty("user_id") Integer user_id,
            @JsonProperty("name") String name,
            @JsonProperty("expiration") String expiration,
            @JsonProperty("document_type") String document_type,
            @JsonProperty("file_type") String file_type,
            @JsonProperty("file_size") Integer file_size,
            @JsonProperty("created_at") String created_at,
            @JsonProperty("updated_at") String updated_at
            ) {
        this.id = id;
        this.company_id = company_id;
        this.employee_id = employee_id;
        this.user_id = user_id;
        this.name = name;
        this.expiration = expiration;
        this.document_type = document_type;
        this.file_type = file_type;
        this.file_size = file_size;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
