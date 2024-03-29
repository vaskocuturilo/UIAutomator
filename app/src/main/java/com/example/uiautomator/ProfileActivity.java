package com.example.uiautomator;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uiautomator.model.WeatherResponse;
import com.example.uiautomator.service.WeatherService;
import com.parse.ParseUser;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileActivity extends AppCompatActivity {
    private TextView weatherData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_acitivity);

        Button logout = findViewById(R.id.logout_button);
        Button saveButton = findViewById(R.id.btn_save);

        weatherData = findViewById(R.id.weather);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = new ProgressDialog(ProfileActivity.this);
                ParseUser.logOutInBackground(e -> {
                    progressDialog.dismiss();
                    if (e == null)
                        alertDisplay(R.string.alert_title, R.string.logout);
                });
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentData();
            }
        });
    }

    private void alertDisplay(final int title, final int message) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this)
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, final int which) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void getCurrentData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(getString(R.string.api_url)).addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherResponse> responseCall = weatherService.getCurrentWeatherData(getString(R.string.api_city), getString(R.string.api_key));
        responseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    String stringBuilder = "Weather is:" + weatherResponse.getWeather().get(0).getMain() +
                            "Temperature is: " + weatherResponse.getWeather().get(0).getDescription();

                    weatherData.setText(stringBuilder);
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });

    }
}
