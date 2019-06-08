package com.example.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JSONApi {

    // https://jsonplaceholder.typicode.com/posts
    /*@GET("posts")
    Call<List<Post>> getPosts();*/


    // https://jsonplaceholder.typicode.com/posts?userId=1
    /*@GET("post")
    Call<List<Post>> getPosts(@Query("userid") int userid);*/



    // https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    // if we dont want to use any of the below parameters we simple pass null
    //Difference between int and Integer is Integer takes null.
    //if we want to have to 2 or more users we simple write another userid query.
    //or better we can use simple Integer Array or list.
    @GET("post")
    Call<List<Post>> getPosts(
            @Query("userid") Integer userid,
            @Query("_sort") String sort,
            @Query("_order") String order
    );

    //We can also use QueryMap if we dont know what would be the key and value.
    //preferable is map
    @GET("post")
    Call<List<Post>> getPosts(@QueryMap Map<String,String> parameters);


    // https://jsonplaceholder.typicode.com/posts/1/comments
    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postid);

    //url = post/3/comments
    @GET
    Call<List<Comments>> getComments(@Url String url);

    @POST("post")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("post")
    Call<Post> createPost(
            @Field("userid") String userid,
            @Field("title") String title,
            @Field("body") String body
    );

    @FormUrlEncoded
    @POST("post")
    Call<Post> createPost(@FieldMap Map<String,String> parameters);

}
