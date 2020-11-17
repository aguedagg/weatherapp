package com.aguedagg.weatherapp.data.dao;

import com.aguedagg.weatherapp.data.City;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Single;
@Dao
public interface WeatherModelDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(List<City> weatherModel);

    @Query("DELETE FROM city")
    Completable deleteAll();

    @Query("SELECT * from city")
    Single<List<City>> getAllEntries();
}
