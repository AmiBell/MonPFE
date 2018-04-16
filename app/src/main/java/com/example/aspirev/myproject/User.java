package com.example.aspirev.myproject;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lenovo on 16/04/2018.
 */

public class User {

    @SerializedName("email")
    public String email;

    @SerializedName("nom")
    public String nom;

    @SerializedName("prenom")
    public String prenom;

    @SerializedName("anneeNaiss")
    public int anneeNaiss;

    @SerializedName("numTel")
    public int numTel;

    @SerializedName("password")
    public String password;

    @SerializedName("genre")
    public String genre;

    @SerializedName("miniBio")
    public String miniBio;

    @SerializedName("id_preferenceFK")
    public int id_preferenceFK;
}
