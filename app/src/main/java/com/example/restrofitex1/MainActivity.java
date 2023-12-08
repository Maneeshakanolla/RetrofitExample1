package com.example.restrofitex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.restrofitex1.adapter.CountryAdapter;
import com.example.restrofitex1.model.CountryModel;
import com.example.restrofitex1.model.Result;
import com.example.restrofitex1.service.GetCountryDataService;
import com.example.restrofitex1.service.RetrofitInstance;

import java.util.ArrayList;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<CountryModel> countriesArrayList;
    RecyclerView recyclerView;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetCountries();
    }


    public Object GetCountries() {

        GetCountryDataService getCountryDataService = RetrofitInstance.getService();
        Call<Result> call=getCountryDataService.getResult();

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                if(result!= null && result.getResult() !=null){
                    countriesArrayList = (ArrayList<CountryModel>) result.getResult();

                   for(CountryModel c: countriesArrayList){
                      Log.i("TAG", ""+c.getName());


                   }

                    ViewData();
                }
            }


            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });

        return countriesArrayList;
    }
    private void ViewData() {

        recyclerView = findViewById(R.id.recyclerView);
        countryAdapter = new CountryAdapter(this,countriesArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(countryAdapter);
    }

}