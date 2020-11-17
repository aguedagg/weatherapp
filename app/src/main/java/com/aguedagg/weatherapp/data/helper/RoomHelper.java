package com.aguedagg.weatherapp.data.helper;

import com.aguedagg.weatherapp.data.City;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface RoomHelper {

    Single<List<City>> getRoomRepo();

    Completable insert(List<City> response);

    Completable deleteAll();
}
