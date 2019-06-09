package com.example.restapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

    @GET("employees")
    Call<List<EmployeeData>> GetEmployees();
}
