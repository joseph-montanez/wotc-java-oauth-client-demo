package com.tcservices.clientapi;

import com.sun.istack.internal.Nullable;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        //-- Create the employee
        Employee employee = main.addEmployee();

        DocumentResponse document = main.uploadDocument();

        //-- Add the customer ID to the document
        main.updateDocument(document.id, employee.id);

        //-- Get the list of documents and print out its ID
        ArrayList<Document> data = main.getDocuments().data;
        data.stream()
                .filter(document1 -> document.id.equals(document1.id) && employee.id.equals(document1.employee_id))
                .forEach(document1 -> System.out.printf("Document upload successful, update also successful ID: %d matches employee ID: %d%n", document1.id, document1.employee_id));

    }
    private DocumentResponse updateDocument(Integer documentID, Integer employeeId) {
        Api api = new Api();

        DocumentUpdateRequest updateRequest = new DocumentUpdateRequest();
        updateRequest.employee_id = employeeId;
        updateRequest.document_type = "8850"; //-- This is up as an 8850 document

        return api.updateDocument(documentID, updateRequest);
    }

    private DocumentPagination getDocuments() {
        Api api = new Api();

        return api.getDocuments();
    }

    @Nullable
    private DocumentResponse uploadDocument() {
        Api api = new Api();

        File file;
        file = new File("./LICENSE");
        DocumentResponse document = null;
        try {
            byte[] fileContent = Files.readAllBytes(file.toPath());
            document = api.uploadDocument(fileContent);

            System.out.printf("Added Document ID: %d%n", document.id);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    private Employee addEmployee() {
        Api api = new Api();

        //-- Add Employee
        Employee addedEmployee;
        Employee newEmployee = new Employee();
        newEmployee.first_name = "John";
        newEmployee.last_name = "Doe";
        newEmployee.email = "johndoe@gmail.com";
        newEmployee.phone = "619-555-5555";
        newEmployee.ssn = "1234";
        newEmployee.started_on = "2018-11-01";
        newEmployee.dob = "1980-01-01";
        newEmployee.address_street = "123 Street";
        newEmployee.address_street2 = "123 Street";
        newEmployee.address_city = "Vista";
        newEmployee.address_state = "CA";
        newEmployee.address_county = "San Diego";
        newEmployee.address_zipcode = "92083";

        addedEmployee = api.addEmployee(newEmployee);

        if (addedEmployee != null && addedEmployee.id > 0) {
            System.out.printf("Added Employee ID: %d%n", addedEmployee.id);
        }

        return addedEmployee;
    }

    private EmployeePagination listEmployees() {
        Api api = new Api();
        //-- List Employees
        EmployeePagination pagination = api.getEmployees();
        System.out.printf("Total Employees: %d%n", pagination.total);
        pagination.data.forEach((Employee employee) -> {
            System.out.printf("Employee ID: %s%n", employee.id);
            System.out.printf("Employee First Name: %s%n", employee.first_name);
        });

        return pagination;
    }

    private void registerCompany() {
        Api api = new Api();

        Random rand = new Random();

        //-- Register Company Details
        RegisterResponse result;
        RegisterRequest registerReq = new RegisterRequest();
        registerReq.ein = String.format("%d-%d", rand.nextInt(99) + 1, rand.nextInt(9999999) + 1);
        registerReq.first_name = "Joe";
        registerReq.last_name = "Doe";
        registerReq.email = String.format("johndoe%d@gamil.com", rand.nextInt(9999999) + 1);
        registerReq.phone = "619-555-5555";
        registerReq.company_name = "Sample Company";
        registerReq.address = "123 Street";
        registerReq.address2 = "123 Street";
        registerReq.city = "Vista";
        registerReq.state = "CA";
        registerReq.zipcode = "92083";
        registerReq.website = "http://google.com";
        registerReq.for_profit = false;

        result = api.register(registerReq);

        if (result != null && result.success) {
            System.out.printf("Company ID: %d%n", result.company.id);
            System.out.printf("WOTC URL: %s%n", result.wotc_url);
            System.out.printf("Access Token: %s%n", result.token);
        } else {
            System.out.print("Unable to register company\n");
            if (result.errors != null) {
                for (String key : result.errors.keySet()) {
                    for (String error : result.errors.get(key)) {
                        System.out.printf("%s: %s\n", key, error);
                    }
                }

            }
        }
    }
}
