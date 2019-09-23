package com.tcservices.clientapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Api {
    private String endPoint = "https://sandbox.wotc.com/portal/api/v1";
    private String lifetimeAccessToken = "INSERT TOKEN HERE";

    Api() {
        System.setProperty("org.apache.commons.logging.Log","org.apache.commons.logging.impl.SimpleLog");
        System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "DEBUG");
        System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.wire", "DEBUG");

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

    public HttpRequest setupHeader(HttpRequest request) {
        return request.header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", lifetimeAccessToken));
    }

    public HttpRequestWithBody setupHeader(HttpRequestWithBody request) {
        return request.header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .header("Authorization", String.format("Bearer %s", lifetimeAccessToken));
    }

    /**
     * Get a list of employees
     *
     * @return
     */
    @Nullable
    public EmployeePagination getEmployees() {
        try {
            String url = String.format("%s/employees", endPoint);
            HttpResponse<EmployeePagination> response;
            response = setupHeader(Unirest.get(url)).asObject(EmployeePagination.class);

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
            String url = String.format("%s/employees", endPoint);
            HttpResponse<Employee> response;
            response = setupHeader(Unirest.post(url)).body(employee).asObject(Employee.class);

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return employee;
    }

    /**
     * Register Company
     *
     * @param company The company / owner details
     * @return The response of the register request
     */
    @Nullable
    public RegisterResponse register(RegisterRequest company) {
        try {
            String url = String.format("%s/register", endPoint);
            HttpResponse<RegisterResponse> response;
            response = setupHeader(Unirest.post(url)).body(company).asObject(RegisterResponse.class);

            RegisterResponse result = response.getBody();
            int status = response.getStatus();
            result.success = status >= 200 && status < 300;

            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Upload Document
     *
     * @param file The bytes of the file to upload
     * @return The response of the upload request
     */
    @Nullable
    public DocumentResponse uploadDocument(byte[] file) {
        try {
            String url = String.format("%s/documents/upload", endPoint);
            HttpResponse<DocumentResponse> response;
            response = setupHeader(Unirest.post(url)).body(file).asObject(DocumentResponse.class);

            return getDocumentResponse(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get Employee WOTC autofill URL
     *
     * @param employeeId The ID of the document
     * @return The response with the URL of the employee WOTC form
     */
    public EmployeeWotcUrlResponse getEmployeeWotcUrl(Integer employeeId) {
        try {
            String url = String.format("%s/employees/%d/wotc/url", endPoint, employeeId);
            HttpResponse<EmployeeWotcUrlResponse> response;
            response = setupHeader(Unirest.get(url)).asObject(EmployeeWotcUrlResponse.class);

            EmployeeWotcUrlResponse body = response.getBody();

            return body;
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get Employee WOTC autofill URL
     *
     * @param employeeId The ID of the document
     * @return The response with the URL of the employee WOTC form
     */
    public EmployeeWotcUrlResponse getEmployeeWotcUrl(Integer employeeId, String redirectUrl) {
        try {
            String url = String.format("%s/employees/%d/wotc/url?redirect=%s", endPoint, employeeId, redirectUrl);
            HttpResponse<EmployeeWotcUrlResponse> response;
            response = setupHeader(Unirest.get(url)).asObject(EmployeeWotcUrlResponse.class);

            EmployeeWotcUrlResponse body = response.getBody();

            return body;
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update Document
     *
     * @param documentId The ID of the document
     * @param data The data to update the document with
     * @return The response of the upload request
     */
    @Nullable
    public DocumentResponse updateDocument(Integer documentId, DocumentUpdateRequest data) {
        try {
            String url = String.format("%s/documents/%d", endPoint, documentId);
            HttpResponse<DocumentResponse> response;
            response = setupHeader(Unirest.put(url)).body(data).asObject(DocumentResponse.class);

            return getDocumentResponse(response);
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    private DocumentResponse getDocumentResponse(HttpResponse<DocumentResponse> response) {
        DocumentResponse result = response.getBody();
        int status = response.getStatus();
        result.success = status >= 200 && status < 300;

        return result;
    }

    /**
     * Get a list of employees
     *
     * @return
     */
    @Nullable
    public DocumentPagination getDocuments() {
        try {
            String url = String.format("%s/documents", endPoint);
            HttpResponse<DocumentPagination> response;
            response = setupHeader(Unirest.get(url)).asObject(DocumentPagination.class);

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Submit applicant WOTC
     *
     * @param wotc The wotc data to submit
     * @return The response of the register request
     */
    @Nullable
    public WotcResponse wotc(FormWotc wotc) {
        try {
            String url = String.format("%s/wotc", endPoint);
            HttpResponse<WotcResponse> response;
            response = setupHeader(Unirest.post(url)).body(wotc).asObject(WotcResponse.class);

            WotcResponse result = response.getBody();
            int status = response.getStatus();
            result.success = status >= 200 && status < 300;

            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Get a list of locations
     *
     * @return
     */
    @Nullable
    public Location[] getLocations() {
        try {
            String url = String.format("%s/locations", endPoint);
            HttpResponse<Location[]> response;
            response = setupHeader(Unirest.get(url)).asObject(Location[].class);


            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();

            return null;
        }
    }

    /**
     * Create location
     *
     * @param location The location data to submit
     * @return The response of the locations created
     */
    @Nullable
    public LocationsResponse createLocation(Location location) {
        try {
            String url = String.format("%s/locations", endPoint);
            HttpResponse<LocationsResponse> response;
            LocationCreateRequest request = new LocationCreateRequest();
            request.location = location;


            response = setupHeader(Unirest.post(url)).body(request).asObject(LocationsResponse.class);

            LocationsResponse result = response.getBody();
            int status = response.getStatus();
            result.success = status >= 200 && status < 300;

            return result;
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Update location
     *
     * @param location The location data to submit
     * @return The response of the locations created
     */
    @Nullable
    public Location[] updateLocation(Location location) {
        try {
            String url = String.format("%s/locations", endPoint);
            HttpResponse<Location[]> response;
            response = setupHeader(Unirest.put(url)).body(location).asObject(Location[].class);

            return response.getBody();
        } catch (UnirestException e) {
            e.printStackTrace();
        }

        return null;
    }
}
