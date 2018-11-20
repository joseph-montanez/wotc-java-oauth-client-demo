package com.tcservices.clientapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sun.istack.internal.Nullable;

import java.io.IOException;

public class Api {
    private String endPoint = "https://sandbox.wotc.com/portal/api/v1";
    private String lifetimeAccessToken = "INSERT TOKEN HERE";

    Api() {
        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * Get a list of employees
     *
     * @return
     */
    @Nullable
    public EmployeePagination getEmployees() {
        try {
            HttpResponse<EmployeePagination> response
                    = Unirest.get(String.format("%s/employees", endPoint))
                    .header("Accept", "application/json")
                    .header("Authorization", String.format("Bearer %s", lifetimeAccessToken))
                    .asObject(EmployeePagination.class);

            EmployeePagination pagination = response.getBody();

            return pagination;
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Add an employee
     *
     * @param employee
     * @return
     */
    @Nullable
    public Employee addEmployee(Employee employee) {
        try {
            HttpResponse<Employee> response = Unirest.post(String.format("%s/employees", endPoint))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .header("Authorization", String.format("Bearer %s", lifetimeAccessToken))
                    .body(employee)
                    .asObject(Employee.class);

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return employee;
    }
}
