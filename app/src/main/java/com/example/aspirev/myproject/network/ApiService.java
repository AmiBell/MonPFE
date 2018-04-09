package com.example.aspirev.myproject.network;


import com.example.aspirev.myproject.entities.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by lenovo on 03/04/2018.
 */

public interface ApiService {

    @POST("register")
    @FormUrlEncoded
    Call<AccessToken> register(@Field("name") String name, @Field("email") String email, @Field("password") String password);
}
