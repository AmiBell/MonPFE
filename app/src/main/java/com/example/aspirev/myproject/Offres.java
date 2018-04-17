package com.example.aspirev.myproject;


import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.sql.Time;

public class Offres {
    @SerializedName("nbEscale")
    public int nbEscale;

    @SerializedName("heureDep")
    public String heureDep;

    @SerializedName("dateDep")
    public String dateDep;

    @SerializedName("nbPlaceTotal")
    public int nbPlaceTotal;

    @SerializedName("genreCompagnie")
    public String genreCompagnie;

    @SerializedName("emailOffre")
    public String emailOffre;

    @SerializedName("vehiculeFK")
    public int vehiculeFK;

    @SerializedName("lieuDepLat")
    public double lieuDepLat;

    @SerializedName("lieuDepLong")
    public double lieuDepLong;

    @SerializedName("lieuArvLat")
    public double lieuArvLat;

    @SerializedName("lieuArvLong")
    public double lieuArvLong;
}
