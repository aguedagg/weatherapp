package com.aguedagg.weatherapp.di.module;

import com.aguedagg.weatherapp.di.WorkerKey;
import com.aguedagg.weatherapp.service.WeatherWorker;
import com.aguedagg.weatherapp.service.WeatherWorkerFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public interface WorkerModule {

    @Binds
    @IntoMap
    @WorkerKey(WeatherWorker.class)
    WeatherWorkerFactory provideCustomWorkerFactory(WeatherWorker.Factory factory);
}
