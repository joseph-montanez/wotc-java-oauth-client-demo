package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {
    public String first_name;
    public String last_name;
    public String email;
    public String phone;
    /**
     * Name of company or DBA
     */
    public String company_name;
    /**
     * The street address
     */
    public String address;
    /**
     * The PO Box, Apt, Suite of the street address
     */
    public String address2;
    /**
     * The city the company operates in
     */
    public String city;
    /**
     * The state the company operates in
     */
    public String state;
    /**
     * The zipcode / postal code the company operates in
     */
    public String zipcode;
    /**
     * The website of the company
     */
    public String website;
    /**
     * The employer identification number (ein) of the company
     */
    public String ein;
    /**
     * The if the company for profit or a non profit
     */
    public Boolean for_profit;
}
