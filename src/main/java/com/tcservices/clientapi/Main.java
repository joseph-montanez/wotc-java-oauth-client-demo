package com.tcservices.clientapi;

public class Main {
    public static void main(String[] args) {
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
}
