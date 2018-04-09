package com.example.aspirev.myproject.entities;

import com.squareup.moshi.Json;

/**
 * Created by lenovo on 03/04/2018.
 */

public class AccessToken {

    @Json(name = "token_type")
    String tokenType;

    @Json(name = "expires_in")
    String expiresIn;

    @Json(name = "access_token")
    String accessToken;

    @Json(name = "refresh_token")
    String refreshToken;


}
