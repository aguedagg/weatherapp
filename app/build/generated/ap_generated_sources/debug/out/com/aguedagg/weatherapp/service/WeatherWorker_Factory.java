// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.service;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.aguedagg.weatherapp.api.rest.WeatherApi;
import com.aguedagg.weatherapp.data.helper.RoomHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WeatherWorker_Factory implements Factory<WeatherWorker> {
  private final Provider<Context> contextProvider;

  private final Provider<WorkerParameters> workerParamsProvider;

  private final Provider<WeatherApi> apiProvider;

  private final Provider<RoomHelper> helperProvider;

  public WeatherWorker_Factory(Provider<Context> contextProvider,
      Provider<WorkerParameters> workerParamsProvider, Provider<WeatherApi> apiProvider,
      Provider<RoomHelper> helperProvider) {
    this.contextProvider = contextProvider;
    this.workerParamsProvider = workerParamsProvider;
    this.apiProvider = apiProvider;
    this.helperProvider = helperProvider;
  }

  @Override
  public WeatherWorker get() {
    WeatherWorker instance = new WeatherWorker(contextProvider.get(), workerParamsProvider.get(), apiProvider.get(), helperProvider.get());
    WeatherWorker_MembersInjector.injectApi(instance, apiProvider.get());
    WeatherWorker_MembersInjector.injectHelper(instance, helperProvider.get());
    return instance;
  }

  public static WeatherWorker_Factory create(Provider<Context> contextProvider,
      Provider<WorkerParameters> workerParamsProvider, Provider<WeatherApi> apiProvider,
      Provider<RoomHelper> helperProvider) {
    return new WeatherWorker_Factory(contextProvider, workerParamsProvider, apiProvider, helperProvider);
  }

  public static WeatherWorker newInstance(Context context, WorkerParameters workerParams,
      WeatherApi api, RoomHelper helper) {
    return new WeatherWorker(context, workerParams, api, helper);
  }
}
