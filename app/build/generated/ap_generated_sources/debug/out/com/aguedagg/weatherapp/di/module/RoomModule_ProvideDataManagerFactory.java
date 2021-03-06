// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.di.module;

import com.aguedagg.weatherapp.api.rest.WeatherRepository;
import com.aguedagg.weatherapp.data.DataManager;
import com.aguedagg.weatherapp.data.helper.RoomHelper;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class RoomModule_ProvideDataManagerFactory implements Factory<DataManager> {
  private final RoomModule module;

  private final Provider<RoomHelper> roomHelperProvider;

  private final Provider<WeatherRepository> repositoryProvider;

  public RoomModule_ProvideDataManagerFactory(RoomModule module,
      Provider<RoomHelper> roomHelperProvider, Provider<WeatherRepository> repositoryProvider) {
    this.module = module;
    this.roomHelperProvider = roomHelperProvider;
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public DataManager get() {
    return provideDataManager(module, roomHelperProvider.get(), repositoryProvider.get());
  }

  public static RoomModule_ProvideDataManagerFactory create(RoomModule module,
      Provider<RoomHelper> roomHelperProvider, Provider<WeatherRepository> repositoryProvider) {
    return new RoomModule_ProvideDataManagerFactory(module, roomHelperProvider, repositoryProvider);
  }

  public static DataManager provideDataManager(RoomModule instance, RoomHelper roomHelper,
      WeatherRepository repository) {
    return Preconditions.checkNotNull(instance.provideDataManager(roomHelper, repository), "Cannot return null from a non-@Nullable @Provides method");
  }
}
