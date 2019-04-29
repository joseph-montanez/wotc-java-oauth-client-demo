package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    public Integer id;
    public Integer company_id;
    public Integer location_id;
    public String last_name;
    public String first_name;
    public String email;
    public String phone;
    public String ssn;
    public String started_on;
    public String dob;
    public String address_street;
    public String address_street2;
    public String address_city;
    public String address_state;
    public String address_county;
    public String address_zipcode;
    public String created_at;
    public String updated_at;
}
