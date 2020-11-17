package com.aguedagg.weatherapp.di.module;

import android.app.Application;

import com.aguedagg.weatherapp.api.rest.AppWeatherRepository;
import com.aguedagg.weatherapp.api.rest.WeatherRepository;
import com.aguedagg.weatherapp.data.AppDataManager;
import com.aguedagg.weatherapp.data.Constants;
import com.aguedagg.weatherapp.data.DataManager;
import com.aguedagg.weatherapp.data.dao.WeatherModelDao;
import com.aguedagg.weatherapp.data.database.AppRoomDatabase;
import com.aguedagg.weatherapp.data.helper.AppRoomHelper;
import com.aguedagg.weatherapp.data.helper.RoomHelper;
import com.aguedagg.weatherapp.di.scope.AppScope;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module(includes = WeatherModule.class)
public class RoomModule {

  @AppScope
  @Provides
  static RoomHelper provideRoomHelper(AppRoomHelper helper) {
    return helper;
  }

  @AppScope
  @Provides
  static WeatherRepository provideWeatherRepository(AppWeatherRepository repository) {
    return repository;
  }

  @AppScope
  @Provides
  DataManager provideDataManager(RoomHelper roomHelper, WeatherRepository repository) {
    return new AppDataManager(roomHelper, repository);
  }

  @AppScope
  @Provides
  AppRoomDatabase provideAppRoomDatabase(Application application) {
    return Room.databaseBuilder(application,
        AppRoomDatabase.class, Constants.ROOM_DB)
        .fallbackToDestructiveMigration()
        .build();
  }

  @AppScope
  @Provides
  WeatherModelDao provideWeatherModelDao(AppRoomDatabase db) {
    return db.modelDao();
  }
}
