package com.aguedagg.weatherapp.api.rest;

import com.aguedagg.weatherapp.data.Constants;
import com.aguedagg.weatherapp.data.WeatherResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET(Constants.REST_CONSTANT)
    Single<WeatherResponse> getRxRepositories(@Query("lat") String latitude, @Query("lon") String longitude, @Query("cnt") int count, @Query("appid") String APIKey, @Query("units") String system);

}
