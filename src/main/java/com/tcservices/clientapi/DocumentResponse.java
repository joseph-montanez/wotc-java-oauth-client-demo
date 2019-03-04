package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentResponse extends Document {

    /**
     * The list of errors
     */
    public HashMap<String, ArrayList<String>> errors;

    /**
     * If the action was successful
     */
    public boolean success;


    @JsonCreator
    public DocumentResponse(
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
            @JsonProperty("updated_at") String updated_at,
            @JsonProperty("errors") HashMap<String, ArrayList<String>> errors
    ) {
        super(id, company_id, employee_id, user_id, name, expiration, document_type, file_type, file_size, created_at, updated_at);
        this.errors = errors;
    }
}
