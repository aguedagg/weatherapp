package com.aguedagg.weatherapp.api.rest;

import com.aguedagg.weatherapp.data.WeatherResponse;

import io.reactivex.Single;

public interface WeatherRepository {

    Single<WeatherResponse> getRepo();
}
