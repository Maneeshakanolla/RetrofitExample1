package com.example.restrofitex1.service;

import com.example.restrofitex1.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCountryDataService {


        @GET("countries")
        Call<Result> getResult();
}

