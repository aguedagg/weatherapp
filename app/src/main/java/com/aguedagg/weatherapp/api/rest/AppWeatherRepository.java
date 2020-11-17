package com.aguedagg.weatherapp.api.rest;

import android.util.Log;

import com.aguedagg.weatherapp.data.Constants;
import com.aguedagg.weatherapp.data.WeatherResponse;

import javax.inject.Inject;

import io.reactivex.Single;

public class AppWeatherRepository implements WeatherRepository {

    @Inject
    public WeatherApi api;

    @Inject
    public AppWeatherRepository(WeatherApi api) {
        this.api = api;
    }

    @Override
    public Single<WeatherResponse> getRepo() {
        return api.getRxRepositories(Constants.TORONTO_LAT, Constants.TORONTO_LON, Constants.NUM_RESULTS, Constants.API_KEY, Constants.UNITS);
    }
}
