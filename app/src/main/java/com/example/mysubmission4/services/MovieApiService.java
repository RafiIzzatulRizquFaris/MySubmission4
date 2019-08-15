package com.example.mysubmission4.services;

import com.example.mysubmission4.response.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {
    @GET("movie/popular")
    Call<MovieResponse> getMovie(@Query("api_key") String apiKey);
}
