// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.di.module;

import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WeatherModule_ProvideGsonFactory implements Factory<Gson> {
  private static final WeatherModule_ProvideGsonFactory INSTANCE = new WeatherModule_ProvideGsonFactory();

  @Override
  public Gson get() {
    return provideGson();
  }

  public static WeatherModule_ProvideGsonFactory create() {
    return INSTANCE;
  }

  public static Gson provideGson() {
    return Preconditions.checkNotNull(WeatherModule.provideGson(), "Cannot return null from a non-@Nullable @Provides method");
  }
}