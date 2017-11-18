package yildirimapps.weatherapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import yildirimapps.weatherapp.data.Channel;
import yildirimapps.weatherapp.data.Item;
import yildirimapps.weatherapp.service.WeatherServiceCallback;
import yildirimapps.weatherapp.service.YahooWeatherService;

public class SecondActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIcon;
    private TextView temperatureText;
    private TextView conditionText;
    private TextView locationText;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        weatherIcon = (ImageView)findViewById(R.id.weatherIcon);
        temperatureText = (TextView)findViewById(R.id.temperature);
        conditionText = (TextView)findViewById(R.id.condition);
        locationText = (TextView)findViewById(R.id.location);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Toronto, Canada");
    }

    @Override
    public void serviceSuccess(Channel channel) {

        dialog.hide();

        Item item = channel.getItem();

        int resourceId = getResources().getIdentifier("drawable/a" + item.getCondition().getCode(), null, getPackageName());
        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIcon.setImageDrawable(weatherIconDrawable);

        temperatureText.setText(item.getCondition().getTemperature() + "\u00b0" + channel.getUnits().getTemperature());
        conditionText.setText(item.getCondition().getDescription());
        locationText.setText(service.getLocation());

    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_SHORT).show();
    }

    public void switch_city(View v){

        Intent switchToIstanbul = new  Intent();
        switchToIstanbul.setClass(this, MainActivity.class);
        startActivity(switchToIstanbul);

    }
}

