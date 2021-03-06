// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp;

import android.app.Activity;
import com.aguedagg.weatherapp.service.AppWeatherWorkerFactory;
import dagger.MembersInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class WeatherApp_MembersInjector implements MembersInjector<WeatherApp> {
  private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

  private final Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider;

  private final Provider<AppWeatherWorkerFactory> factoryProvider;

  public WeatherApp_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<AppWeatherWorkerFactory> factoryProvider) {
    this.androidInjectorProvider = androidInjectorProvider;
    this.activityDispatchingAndroidInjectorProvider = activityDispatchingAndroidInjectorProvider;
    this.factoryProvider = factoryProvider;
  }

  public static MembersInjector<WeatherApp> create(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<DispatchingAndroidInjector<Activity>> activityDispatchingAndroidInjectorProvider,
      Provider<AppWeatherWorkerFactory> factoryProvider) {
    return new WeatherApp_MembersInjector(androidInjectorProvider, activityDispatchingAndroidInjectorProvider, factoryProvider);}

  @Override
  public void injectMembers(WeatherApp instance) {
    DaggerApplication_MembersInjector.injectAndroidInjector(instance, androidInjectorProvider.get());
    injectActivityDispatchingAndroidInjector(instance, activityDispatchingAndroidInjectorProvider.get());
    injectFactory(instance, factoryProvider.get());
  }

  public static void injectActivityDispatchingAndroidInjector(WeatherApp instance,
      DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector) {
    instance.activityDispatchingAndroidInjector = activityDispatchingAndroidInjector;
  }

  public static void injectFactory(WeatherApp instance, AppWeatherWorkerFactory factory) {
    instance.factory = factory;
  }
}
