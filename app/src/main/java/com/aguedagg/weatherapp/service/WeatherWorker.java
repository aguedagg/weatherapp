package com.aguedagg.weatherapp.service;

import android.content.Context;
import android.util.Log;

import com.aguedagg.weatherapp.api.rest.WeatherApi;
import com.aguedagg.weatherapp.data.Constants;
import com.aguedagg.weatherapp.data.helper.RoomHelper;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.RxWorker;
import androidx.work.WorkerParameters;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class WeatherWorker extends RxWorker {

    @Inject
    WeatherApi api;

    @Inject
    RoomHelper helper;

    /**
     * Instantiates a custom worker that takes in Retrofit and Room interfaces.
     *
     * @param context      the context
     * @param workerParams the worker params
     * @param api          the api
     * @param helper       the helper
     */
    @Inject
    public WeatherWorker(@NonNull Context context, @NonNull WorkerParameters workerParams, WeatherApi api, RoomHelper helper) {
        super(context, workerParams);
        this.api = api;
        this.helper = helper;
    }


    @NonNull
    @Override
    public Single<Result> createWork() {
        return api.getRxRepositories(Constants.TORONTO_LAT, Constants.TORONTO_LON, Constants.NUM_RESULTS, Constants.API_KEY, Constants.UNITS)
                .flatMapCompletable(weatherModels -> helper.insert(weatherModels.getCities()))
                .toSingleDefault(Result.success())
                .onErrorReturnItem(Result.failure())
                .observeOn(Schedulers.io());
    }

    public static class Factory implements WeatherWorkerFactory {

        private final Provider<WeatherApi> weatherApiProvider;

        private final Provider<RoomHelper> roomHelperProvider;

        @Inject
        public Factory(Provider<WeatherApi> weatherApiProvider, Provider<RoomHelper> roomHelperProvider) {
            this.weatherApiProvider = weatherApiProvider;
            this.roomHelperProvider = roomHelperProvider;
        }

        @Override
        public ListenableWorker create(Context appContext, WorkerParameters workerParameters) {
            return new WeatherWorker(appContext, workerParameters, weatherApiProvider.get(), roomHelperProvider.get());
        }
    }
}
