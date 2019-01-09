package com.tcservices.clientapi;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        new Main().registerCompany();
    }

    private void addEmployee() {
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

        //-- List Employees
        EmployeePagination pagination = api.getEmployees();
        System.out.printf("Total Employees: %d%n", pagination.total);
        pagination.data.forEach((Employee employee) -> {
            System.out.printf("Employee ID: %s%n", employee.id);
            System.out.printf("Employee First Name: %s%n", employee.first_name);
        });
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
