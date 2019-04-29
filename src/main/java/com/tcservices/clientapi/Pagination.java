package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class Pagination {
    int current_page;
    String first_page_url;
    int from;
    int last_page;
    String last_page_url;
    String next_page_url;
    String path;
    int per_page;
    String prev_page_url;
    int to;
    int total;

    @JsonCreator
    public Pagination(
            @JsonProperty("current_page") int current_page,
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
        this.current_page = current_page;
        this.first_page_url = first_page_url;
        this.from = from;
        this.last_page = last_page;
        this.last_page_url = last_page_url;
        this.next_page_url = next_page_url;
        this.path = path;
        this.per_page = per_page;
        this.prev_page_url = prev_page_url;
        this.to = to;
        this.total = total;
    }
}

