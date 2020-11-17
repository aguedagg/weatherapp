package com.aguedagg.weatherapp.service;

import android.content.Context;

import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;

public interface WeatherWorkerFactory {

    ListenableWorker create(Context appContext, WorkerParameters workerParameters);
}
