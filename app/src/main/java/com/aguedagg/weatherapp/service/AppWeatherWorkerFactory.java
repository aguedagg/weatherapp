package com.aguedagg.weatherapp.service;

import android.content.Context;

import java.util.Map;
import java.util.Objects;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.ListenableWorker;
import androidx.work.WorkerFactory;
import androidx.work.WorkerParameters;

public class AppWeatherWorkerFactory extends WorkerFactory {

    private final Map<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>> workersFactories;

    @Inject
    public AppWeatherWorkerFactory(Map<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>> workersFactories) {
        this.workersFactories = workersFactories;
    }

    @Nullable
    @Override
    public ListenableWorker createWorker(@NonNull Context appContext, @NonNull String workerClassName, @NonNull WorkerParameters workerParameters) {
        Provider<WeatherWorkerFactory> factoryProvider = getWorkerFactoryProviderByKey(workersFactories, workerClassName);
        return factoryProvider.get().create(appContext, workerParameters);
    }

    private Provider<WeatherWorkerFactory> getWorkerFactoryProviderByKey(
            Map<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>> map, String key) {

        for (Map.Entry<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>> entry : map.entrySet()) {
            if (Objects.equals(key, entry.getKey().getName())) {
                return entry.getValue();
            }
        }
        return null;
    }
}
