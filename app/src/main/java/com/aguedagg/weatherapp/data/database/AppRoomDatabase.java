package com.aguedagg.weatherapp.data.database;

import com.aguedagg.weatherapp.data.City;
import com.aguedagg.weatherapp.data.dao.WeatherModelDao;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {City.class}, version = 1, exportSchema = false)
public abstract class AppRoomDatabase extends RoomDatabase {

  public abstract WeatherModelDao modelDao();
}
