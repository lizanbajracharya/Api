package com.example.api.api;

import com.example.api.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;

public interface EmployeeAPI {
    @GET("employees")
    Call<List<Employee>> getAllEmployees();

    //Get Employee on basis of EmpiD
    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empId);
}
