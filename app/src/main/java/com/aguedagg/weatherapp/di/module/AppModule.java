package com.aguedagg.weatherapp.di.module;

import com.aguedagg.weatherapp.api.base.rx.AppSchedulerProvider;
import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import com.aguedagg.weatherapp.di.scope.AppScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {WeatherModule.class, RoomModule.class})
public class AppModule {

    @AppScope
    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
