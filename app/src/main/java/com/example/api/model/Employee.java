package com.example.api.model;

public class Employee {
    private int id;
    private String employee_name;
    private Float employee_salary;
    private int employee_age;
    private String employee_image;

    public Employee(int id, String employee_name, Float employee_salary, int employee_age, String employee_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.employee_image = employee_image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Float getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Float employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getEmployee_image() {
        return employee_image;
    }

    public void setEmployee_image(String employee_image) {
        this.employee_image = employee_image;
    }
}
