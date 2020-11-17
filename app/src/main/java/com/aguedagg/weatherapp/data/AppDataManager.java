package com.aguedagg.weatherapp.data;

import android.util.Log;

import com.aguedagg.weatherapp.api.rest.WeatherRepository;
import com.aguedagg.weatherapp.data.helper.RoomHelper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AppDataManager implements DataManager {

    @Inject
    RoomHelper roomHelper;

    @Inject
    WeatherRepository repository;

    @Inject
    public AppDataManager(RoomHelper helper, WeatherRepository repo) {
        this.roomHelper = helper;
        this.repository = repo;
    }

    @Override
    public Single<WeatherResponse> getRepo() {
        return repository.getRepo();
    }

    @Override
    public Single<List<City>> getRoomRepo() {
        Log.e("AGUEDAGG", "getRoomRepo()");
        return roomHelper.getRoomRepo();
    }

    @Override
    public Completable insert(List<City> weatherModel) {
        return roomHelper.insert(weatherModel);
    }

    @Override
    public Completable deleteAll() {
        return roomHelper.deleteAll();
    }
}
