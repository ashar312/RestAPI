package com.example.restapi;

public class EmployeeData {
    private int id;
    private String employee_name;
    private String employee_salary;
    private String employee_age;
    private String profile_image;

    public EmployeeData(String employee_name, String employee_salary, String employee_age, String profile_image) {
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public int getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public String getEmployee_salary() {
        return employee_salary;
    }

    public String getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }
}
