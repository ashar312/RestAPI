package com.example.restapi.API_interfaces;

import com.example.restapi.EmployeeData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface EmployeeAPI {

    @GET("employees")
    Call<List<EmployeeData>> GetEmployees();

    @GET("employees/{id}")
    Call<EmployeeData> GetEmployee(@Path("id") int id);
}
