package com.example.restapi.API_interfaces;

import com.example.restapi.Models.MyModel;
import com.example.restapi.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApi {

    @GET("status/5e1841ebf1d2d620bc2cdeef")
    Call<MyModel> getPosts();




}
