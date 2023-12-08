package com.example.restrofitex1.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private  static Retrofit retrofit=null;
    private  static  String Base_URL="https://api.printful.com/";
    public  static  GetCountryDataService getService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(GetCountryDataService.class);
    }

}
