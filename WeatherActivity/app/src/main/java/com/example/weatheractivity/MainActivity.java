package com.example.weatheractivity;

import static retrofit2.Retrofit.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.weatheractivity.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


   String url="https://api.openweathermap.org/data/2.5/weather?q={city%20name}&appid={API%20key}";
   String apiKey="c2bf77dbaf95c0b4e243e2886af3a73d";
    @Override
    protected void
    onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SimpleDateFormat format=new SimpleDateFormat("dd MM yyyy");
        String currentDate=format.format(new Date());
        binding.date.setText(currentDate);

        binding.searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(binding.searchView.getQuery().toString())){


                }
            }
        });


        String CITY_NAME=binding.searchView.getQuery().toString();
getWeather("jaipur");



    }
  public void getWeather(String city_name){
        Retrofit retrofit=new Retrofit.Builder().baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        InterfaceApi interfaceApi= retrofit.create(InterfaceApi.class);
        Call<weatherApp>weatherDataCall=interfaceApi.gateData(city_name,"c2bf77dbaf95c0b4e243e2886af3a73d","metric");
        weatherDataCall.enqueue(new Callback<weatherApp>() {
            @Override
            public void onResponse(Call<weatherApp> call, Response<weatherApp> response) {

               weatherApp data=response.body();
               if(response.isSuccessful()){



//               main to=data.getMain();
                  Main to=data.getMain();

              

               binding.textView4.setText(String.valueOf(to.getTemp())+"°C");
               binding.textView6.setText(String.valueOf(to.getTemp_max())+"°C");
               binding.textView7.setText(String.valueOf(to.getTemp_min())+"°C");
               binding.humidity.setText(String.valueOf(to.getHumidity()));






               }




            }

            @Override
            public void onFailure(Call<weatherApp> call, Throwable t) {

            }


        });


  }



}