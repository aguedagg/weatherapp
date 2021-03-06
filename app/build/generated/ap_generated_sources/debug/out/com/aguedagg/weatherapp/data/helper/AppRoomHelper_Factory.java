// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.data.helper;

import com.aguedagg.weatherapp.data.database.AppRoomDatabase;
import dagger.internal.Factory;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppRoomHelper_Factory implements Factory<AppRoomHelper> {
  private final Provider<AppRoomDatabase> appDatabaseProvider;

  public AppRoomHelper_Factory(Provider<AppRoomDatabase> appDatabaseProvider) {
    this.appDatabaseProvider = appDatabaseProvider;
  }

  @Override
  public AppRoomHelper get() {
    AppRoomHelper instance = new AppRoomHelper(appDatabaseProvider.get());
    AppRoomHelper_MembersInjector.injectAppDatabase(instance, appDatabaseProvider.get());
    return instance;
  }

  public static AppRoomHelper_Factory create(Provider<AppRoomDatabase> appDatabaseProvider) {
    return new AppRoomHelper_Factory(appDatabaseProvider);
  }

  public static AppRoomHelper newInstance(AppRoomDatabase appDatabase) {
    return new AppRoomHelper(appDatabase);
  }
}
