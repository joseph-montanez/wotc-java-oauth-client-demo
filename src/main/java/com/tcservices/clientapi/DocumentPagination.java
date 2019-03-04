package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DocumentPagination extends Pagination {
    ArrayList<Document> data;

    @JsonCreator
    public DocumentPagination(
            @JsonProperty("current_page") int current_page,
            @JsonProperty("data") ArrayList<Document> data,
            @JsonProperty("first_page_url") String first_page_url,
            @JsonProperty("from") int from,
            @JsonProperty("last_page") int last_page,
            @JsonProperty("last_page_url") String last_page_url,
            @JsonProperty("next_page_url") String next_page_url,
            @JsonProperty("path") String path,
            @JsonProperty("per_page") int per_page,
            @JsonProperty("prev_page_url") String prev_page_url,
            @JsonProperty("to") int to,
            @JsonProperty("total") int total
    ) {
        super(current_page, first_page_url, from, last_page, last_page_url, next_page_url, path, per_page, prev_page_url, to, total);
        this.data = data;
    }
}
