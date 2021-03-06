package com.example.jordan.societhy_android.APIRequest;

import com.example.jordan.societhy_android.Models.TokenModel;
import com.example.jordan.societhy_android.Models.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
/**
 * Created by jordan on 24/02/2016.
 */
public interface IAPIRequest {

    @GET("/login")
    Call<TokenModel> getToken(@Query("login") String login, @Query("password") String pass);

    @GET("/user/{u}")
    Call<UserModel> getUser(@Path("u") String user);
}
