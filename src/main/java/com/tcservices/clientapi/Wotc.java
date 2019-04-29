package com.tcservices.clientapi;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wotc {
    public enum SnapBenefitsBeforeField
    {
        @JsonProperty("3")
        THREE_MONTHS,
        @JsonProperty("6")
        SIX_MONTHS
    }
    public enum TanfBeforeField
    {
        @JsonProperty("9")
        NINE_MONTHS,
        @JsonProperty("18")
        EIGHTEEN_MONTHS,
        @JsonProperty("2")
        TWO_MONTHS
    }
    public enum ConvictedTypeField
    {
        @JsonProperty("federal")
        FEDERAL,
        @JsonProperty("state")
        STATE
    }

    public Integer id;
    public String first_name;
    public String middle_name;
    public String last_name;
    public String other_last_names;
    public String dob;
    public String address_street;
    public String address_street2;
    public String address_city;
    public String address_state;
    public String address_county;
    public String address_zipcode;
    public String phone;
    public String email;
    public String ssn;
    public String applied_on;
    public Boolean has_startdate;
    public String started_on;
    public Float starting_wage;
    public String position;

    //-- Rehire
    public Boolean rehire;
    public String rehire_last_employment;
    //-- Unemployeement
    public Boolean unemployment_comp;
    public String unemployment_comp_start;
    //-- SNAP
    public Boolean snap_benefits;
    public SnapBenefitsBeforeField snap_benefits_before;
    public String snap_benefits_extras_name;
    public String snap_benefits_extras_city_state;
    //-- TANF
    public Boolean tanf_benefits;
    public TanfBeforeField tanf_benefits_before;
    public String tanf_benefits_extras_name;
    public String tanf_benefits_extras_city_state;
    //-- Veteran
    public Boolean veteran;
    public Boolean veteran_compensation;
    public Boolean veteran_compensation_discharged;
    public Boolean veteran_compensation_unemployed;
    public Boolean veteran_snap;
    public String veteran_snap_name;
    public String veteran_snap_city_state;
    public Boolean veteran_unemployed_6_or_greater;
    public Boolean veteran_unemployed_6_less_than;
    //-- Convicted
    public Boolean convicted_before_hired;
    public String convicted_date;
    public String convicted_release;
    public ConvictedTypeField convicted_type;
    //-- Misc
    public Boolean rural_or_empowerment_zone;
    public Boolean rehab_agency;
    public Boolean employment_network;
    public Boolean veteran_affairs;
    public Boolean ssi_benefit;
    public Boolean conditional_certification;
    //-- Signature
    public String signature_data;
    public String signature_date;
    public String signature_image;



    public String created_at;
    public String updated_at;
    public Wotc(){}

    @JsonCreator
    public Wotc(
            @JsonProperty("id") Integer id,
            @JsonProperty("first_name") String first_name,
            @JsonProperty("middle_name") String middle_name,
            @JsonProperty("last_name") String last_name,
            @JsonProperty("other_last_names") String other_last_names,
            @JsonProperty("dob") String dob,
            @JsonProperty("address_street") String address_street,
            @JsonProperty("address_street2") String address_street2,
            @JsonProperty("address_city") String address_city,
            @JsonProperty("address_state") String address_state,
            @JsonProperty("address_county") String address_county,
            @JsonProperty("address_zipcode") String address_zipcode,
            @JsonProperty("phone") String phone,
            @JsonProperty("email") String email,
            @JsonProperty("applied_on") String applied_on,
            @JsonProperty("started_on") String started_on,
            @JsonProperty("has_startdate") Boolean has_startdate,
            @JsonProperty("starting_wage") Float starting_wage,
            @JsonProperty("ssn") String ssn,
            @JsonProperty("position") String position,
            //-- Rehire
            @JsonProperty("rehire") Boolean rehire,
            @JsonProperty("rehire_last_employment") String rehire_last_employment,
            //-- Unemployeement
            @JsonProperty("unemployment_comp") Boolean unemployment_comp,
            @JsonProperty("unemployment_comp_start") String unemployment_comp_start,
            //-- SNAP
            @JsonProperty("snap_benefits") Boolean snap_benefits,
            @JsonProperty("snap_benefits_before") SnapBenefitsBeforeField snap_benefits_before,
            @JsonProperty("snap_benefits_extras_name") String snap_benefits_extras_name,
            @JsonProperty("snap_benefits_extras_city_state") String snap_benefits_extras_city_state,
            //-- TANF
            @JsonProperty("tanf_benefits") Boolean tanf_benefits,
            @JsonProperty("tanf_benefits_before") TanfBeforeField tanf_benefits_before,
            @JsonProperty("tanf_benefits_extras_name") String tanf_benefits_extras_name,
            @JsonProperty("tanf_benefits_extras_city_state") String tanf_benefits_extras_city_state,
            //-- Veteran
            @JsonProperty("veteran") Boolean veteran,
            @JsonProperty("veteran_compensation") Boolean veteran_compensation,
            @JsonProperty("veteran_compensation_discharged") Boolean veteran_compensation_discharged,
            @JsonProperty("veteran_compensation_unemployed") Boolean veteran_compensation_unemployed,
            @JsonProperty("veteran_snap") Boolean veteran_snap,
            @JsonProperty("veteran_snap_name") String veteran_snap_name,
            @JsonProperty("veteran_snap_city_state") String veteran_snap_city_state,
            @JsonProperty("veteran_unemployed_6_or_greater") Boolean veteran_unemployed_6_or_greater,
            @JsonProperty("veteran_unemployed_6_less_than") Boolean veteran_unemployed_6_less_than,
            //-- Convicted
            @JsonProperty("convicted_before_hired") Boolean convicted_before_hired,
            @JsonProperty("convicted_date") String convicted_date,
            @JsonProperty("convicted_release") String convicted_release,
            @JsonProperty("convicted_type") ConvictedTypeField convicted_type,
            //-- Misc
            @JsonProperty("rural_or_empowerment_zone") Boolean rural_or_empowerment_zone,
            @JsonProperty("rehab_agency") Boolean rehab_agency,
            @JsonProperty("employment_network") Boolean employment_network,
            @JsonProperty("veteran_affairs") Boolean veteran_affairs,
            @JsonProperty("ssi_benefit") Boolean ssi_benefit,
            @JsonProperty("conditional_certification") Boolean conditional_certification,
            //-- Signature
            @JsonProperty("signature_data") String signature_data,
            @JsonProperty("signature_date") String signature_date,
            @JsonProperty("signature_date") String signature_image,

            @JsonProperty("created_at") String created_at,
            @JsonProperty("updated_at") String updated_at
    ) {
        this.id = id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.other_last_names = other_last_names;
        this.dob = dob;
        this.address_street = address_street;
        this.address_street2 = address_street2;
        this.address_city = address_city;
        this.phone = phone;
        this.address_state = address_state;
        this.address_county = address_county;
        this.address_zipcode = address_zipcode;
        this.ssn = ssn;
        this.phone = phone;
        this.email = email;
        this.applied_on = applied_on;
        this.has_startdate = has_startdate;
        this.started_on = started_on;
        this.starting_wage = starting_wage;
        this.position = position;
        //-- Rehire
        this.rehire = rehire;
        this.rehire_last_employment = rehire_last_employment;
        //-- Unemployeement
        this.unemployment_comp = unemployment_comp;
        this.unemployment_comp_start = unemployment_comp_start;
        //-- SNAP
        this.snap_benefits = snap_benefits;
        this.snap_benefits_before = snap_benefits_before;
        this.snap_benefits_extras_name = snap_benefits_extras_name;
        this.snap_benefits_extras_city_state = snap_benefits_extras_city_state;
        //-- TANF
        this.tanf_benefits = tanf_benefits;
        this.tanf_benefits_before = tanf_benefits_before;
        this.tanf_benefits_extras_name = tanf_benefits_extras_name;
        this.tanf_benefits_extras_city_state = tanf_benefits_extras_city_state;
        //--Veteran
        this.veteran = veteran;
        this.veteran_compensation = veteran_compensation;
        this.veteran_compensation_discharged = veteran_compensation_discharged;
        this.veteran_compensation_unemployed = veteran_compensation_unemployed;
        this.veteran_snap = veteran_snap;
        this.veteran_snap_name = veteran_snap_name;
        this.veteran_snap_city_state = veteran_snap_city_state;
        this.veteran_unemployed_6_or_greater = veteran_unemployed_6_or_greater;
        this.veteran_unemployed_6_less_than = veteran_unemployed_6_less_than;
        //-- Convicted
        this.convicted_before_hired = convicted_before_hired;
        this.convicted_date = convicted_date;
        this.convicted_release = convicted_release;
        this.convicted_type = convicted_type;
        //-- Misc
        this.rural_or_empowerment_zone = rural_or_empowerment_zone;
        this.rehab_agency = rehab_agency;
        this.employment_network = employment_network;
        this.veteran_affairs = veteran_affairs;
        this.ssi_benefit = ssi_benefit;
        this.conditional_certification = conditional_certification;
        //-- Signature
        this.signature_data = signature_data;
        this.signature_date = signature_date;
        this.signature_image = signature_image;

        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
