// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.di.module;

import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideSchedulerProviderFactory implements Factory<SchedulerProvider> {
  private final AppModule module;

  public AppModule_ProvideSchedulerProviderFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public SchedulerProvider get() {
    return provideSchedulerProvider(module);
  }

  public static AppModule_ProvideSchedulerProviderFactory create(AppModule module) {
    return new AppModule_ProvideSchedulerProviderFactory(module);
  }

  public static SchedulerProvider provideSchedulerProvider(AppModule instance) {
    return Preconditions.checkNotNull(instance.provideSchedulerProvider(), "Cannot return null from a non-@Nullable @Provides method");
  }
}
