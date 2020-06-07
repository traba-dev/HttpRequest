package com.example.httprequest.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.httprequest.Interfaces.weatherInterfaces;
import com.example.httprequest.Model.City;
import com.example.httprequest.Model.Ciudad;
import com.example.httprequest.R;
import com.example.httprequest.Utils.Utils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class httpRequest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        //Usando Libreria GsonFactory
       // weatherInterfaces service = Utils.getRetrofit().create(weatherInterfaces.class);
        //Usando deserializador MyDes
        weatherInterfaces service2 = Utils.getRetrofitDeserialize().create(weatherInterfaces.class);

        Call<City> cityCall = service2.getCityCelsius(Utils.getCity(),Utils.getApikey(),"metric");
        Call<Ciudad> ciudadCall = service2.getCiudadCelsius(Utils.getCity(),Utils.getApikey(),"metric");

        ciudadCall.enqueue(new Callback<Ciudad>() {
            @Override
            public void onResponse(Call<Ciudad> call, Response<Ciudad> response) {
                Ciudad ciudad = response.body();
            }

            @Override
            public void onFailure(Call<Ciudad> call, Throwable t) {

            }
        });

        cityCall.enqueue(new Callback<City>() {
            @Override
            public void onResponse(Call<City> call, Response<City> response) {
                City city = response.body();
            }

            @Override
            public void onFailure(Call<City> call, Throwable t) {
                Toast.makeText(httpRequest.this,t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });



    }
}
