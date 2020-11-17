package com.aguedagg.weatherapp;

import android.app.Activity;

import com.aguedagg.weatherapp.data.Constants;
import com.aguedagg.weatherapp.di.DaggerAppComponent;
import com.aguedagg.weatherapp.service.AppWeatherWorkerFactory;
import com.aguedagg.weatherapp.service.WeatherWorker;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerApplication;

public class WeatherApp extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Inject
    AppWeatherWorkerFactory factory;

    @Override
    public void onCreate() {
        super.onCreate();
        configureWorkManager();
        setupPeriodicWork();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    private void setupPeriodicWork() {
        PeriodicWorkRequest request = getBuilder().build();
        WorkManager.getInstance(this).enqueue(request);
    }

    private void configureWorkManager() {
        Configuration config = new Configuration.Builder()
                .setWorkerFactory(factory)
                .build();

        WorkManager.initialize(this, config);
    }

    private PeriodicWorkRequest.Builder getBuilder() {
        return new PeriodicWorkRequest.Builder(
                WeatherWorker.class, Constants.WORK_INTERVAL_MINUTES, TimeUnit.SECONDS)
                .setConstraints(getConstraints())
                .setInitialDelay(0, TimeUnit.SECONDS);
    }

    private Constraints getConstraints() {
        return new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
    }
}
