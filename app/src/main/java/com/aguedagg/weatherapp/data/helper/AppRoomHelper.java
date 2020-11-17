package com.aguedagg.weatherapp.data.helper;

import com.aguedagg.weatherapp.data.City;
import com.aguedagg.weatherapp.data.database.AppRoomDatabase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Single;

public class AppRoomHelper implements RoomHelper {

    @Inject
    public AppRoomDatabase appDatabase;

    @Inject
    public AppRoomHelper(AppRoomDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @Override
    public Single<List<City>> getRoomRepo() {
        return appDatabase.modelDao().getAllEntries();
    }

    @Override
    public Completable insert(List<City> weatherModel) {
        return appDatabase.modelDao().insert(weatherModel);
    }

    @Override
    public Completable deleteAll() {
        return appDatabase.modelDao().deleteAll();
    }
}
