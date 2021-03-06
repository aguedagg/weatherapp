// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.ui;

import com.aguedagg.weatherapp.api.base.BaseViewModel_MembersInjector;
import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import com.aguedagg.weatherapp.data.DataManager;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<SchedulerProvider> schedulerProviderAndProvider;

  private final Provider<DataManager> dataManagerAndAppDataManagerProvider;

  public MainViewModel_Factory(Provider<SchedulerProvider> schedulerProviderAndProvider,
      Provider<DataManager> dataManagerAndAppDataManagerProvider) {
    this.schedulerProviderAndProvider = schedulerProviderAndProvider;
    this.dataManagerAndAppDataManagerProvider = dataManagerAndAppDataManagerProvider;
  }

  @Override
  public MainViewModel get() {
    MainViewModel instance = new MainViewModel(schedulerProviderAndProvider.get(), dataManagerAndAppDataManagerProvider.get());
    BaseViewModel_MembersInjector.injectDataManager(instance, dataManagerAndAppDataManagerProvider.get());
    BaseViewModel_MembersInjector.injectSchedulerProvider(instance, schedulerProviderAndProvider.get());
    return instance;
  }

  public static MainViewModel_Factory create(
      Provider<SchedulerProvider> schedulerProviderAndProvider,
      Provider<DataManager> dataManagerAndAppDataManagerProvider) {
    return new MainViewModel_Factory(schedulerProviderAndProvider, dataManagerAndAppDataManagerProvider);
  }

  public static MainViewModel newInstance(SchedulerProvider provider, DataManager appDataManager) {
    return new MainViewModel(provider, appDataManager);
  }
}
