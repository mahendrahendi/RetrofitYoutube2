package com.example.hendi.retrofityoutube;

import android.graphics.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://api.themoviedb.org";

    @GET("/3/search/movie?api_key=2693145f0d898527f366ad0b62c2eddd&query=Jack+Reacher")
    Call<MovieResults> getHeroes();

}
