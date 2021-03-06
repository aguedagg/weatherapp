// Generated by Dagger (https://dagger.dev).
package com.aguedagg.weatherapp.di;

import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.work.ListenableWorker;
import com.aguedagg.weatherapp.WeatherApp;
import com.aguedagg.weatherapp.WeatherApp_MembersInjector;
import com.aguedagg.weatherapp.api.base.BaseActivity_MembersInjector;
import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import com.aguedagg.weatherapp.api.rest.AppWeatherRepository;
import com.aguedagg.weatherapp.api.rest.AppWeatherRepository_Factory;
import com.aguedagg.weatherapp.api.rest.WeatherApi;
import com.aguedagg.weatherapp.api.rest.WeatherRepository;
import com.aguedagg.weatherapp.data.DataManager;
import com.aguedagg.weatherapp.data.database.AppRoomDatabase;
import com.aguedagg.weatherapp.data.helper.AppRoomHelper;
import com.aguedagg.weatherapp.data.helper.AppRoomHelper_Factory;
import com.aguedagg.weatherapp.data.helper.RoomHelper;
import com.aguedagg.weatherapp.di.module.ActivityModule;
import com.aguedagg.weatherapp.di.module.ActivityModule_ProvideLinearLayoutManagerFactory;
import com.aguedagg.weatherapp.di.module.AppModule;
import com.aguedagg.weatherapp.di.module.AppModule_ProvideSchedulerProviderFactory;
import com.aguedagg.weatherapp.di.module.RoomModule;
import com.aguedagg.weatherapp.di.module.RoomModule_ProvideAppRoomDatabaseFactory;
import com.aguedagg.weatherapp.di.module.RoomModule_ProvideDataManagerFactory;
import com.aguedagg.weatherapp.di.module.RoomModule_ProvideRoomHelperFactory;
import com.aguedagg.weatherapp.di.module.RoomModule_ProvideWeatherRepositoryFactory;
import com.aguedagg.weatherapp.di.module.ViewModelProviderFactory;
import com.aguedagg.weatherapp.di.module.WeatherModule_ProvideHttpLoggingInterceptorFactory;
import com.aguedagg.weatherapp.di.module.WeatherModule_ProvideOkHttpClientFactory;
import com.aguedagg.weatherapp.di.module.WeatherModule_ProvideWeatherApiFactory;
import com.aguedagg.weatherapp.service.AppWeatherWorkerFactory;
import com.aguedagg.weatherapp.service.WeatherWorker;
import com.aguedagg.weatherapp.service.WeatherWorkerFactory;
import com.aguedagg.weatherapp.service.WeatherWorker_Factory_Factory;
import com.aguedagg.weatherapp.ui.MainActivity;
import com.aguedagg.weatherapp.ui.MainActivity_MembersInjector;
import com.aguedagg.weatherapp.ui.MainAdapter;
import com.aguedagg.weatherapp.ui.MainViewModel;
import com.aguedagg.weatherapp.ui.MainViewModel_Factory;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication_MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.DispatchingAndroidInjector_Factory;
import dagger.android.internal.AndroidInjectionKeys;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import java.util.Collections;
import java.util.Map;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private Provider<ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent.Factory> mainActivitySubcomponentFactoryProvider;

  private Provider<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;

  private Provider<OkHttpClient> provideOkHttpClientProvider;

  private Provider<WeatherApi> provideWeatherApiProvider;

  private Provider<Application> applicationProvider;

  private Provider<AppRoomDatabase> provideAppRoomDatabaseProvider;

  private Provider<AppRoomHelper> appRoomHelperProvider;

  private Provider<RoomHelper> provideRoomHelperProvider;

  private Provider<WeatherWorker.Factory> factoryProvider;

  private Provider<SchedulerProvider> provideSchedulerProvider;

  private Provider<AppWeatherRepository> appWeatherRepositoryProvider;

  private Provider<WeatherRepository> provideWeatherRepositoryProvider;

  private Provider<DataManager> provideDataManagerProvider;

  private DaggerAppComponent(AppModule appModuleParam, RoomModule roomModuleParam,
      Application applicationParam) {

    initialize(appModuleParam, roomModuleParam, applicationParam);
  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private Map<String, Provider<AndroidInjector.Factory<?>>> getMapOfStringAndProviderOfAndroidInjectorFactoryOf(
      ) {
    return Collections.<String, Provider<AndroidInjector.Factory<?>>>singletonMap(AndroidInjectionKeys.of("com.aguedagg.weatherapp.ui.MainActivity"), (Provider) mainActivitySubcomponentFactoryProvider);}

  private DispatchingAndroidInjector<Object> getDispatchingAndroidInjectorOfObject() {
    return DispatchingAndroidInjector_Factory.newInstance(Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>emptyMap(), getMapOfStringAndProviderOfAndroidInjectorFactoryOf());}

  private DispatchingAndroidInjector<Activity> getDispatchingAndroidInjectorOfActivity() {
    return DispatchingAndroidInjector_Factory.newInstance(Collections.<Class<?>, Provider<AndroidInjector.Factory<?>>>emptyMap(), getMapOfStringAndProviderOfAndroidInjectorFactoryOf());}

  private Map<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>> getMapOfClassOfAndProviderOfWeatherWorkerFactory(
      ) {
    return Collections.<Class<? extends ListenableWorker>, Provider<WeatherWorkerFactory>>singletonMap(WeatherWorker.class, (Provider) factoryProvider);}

  @SuppressWarnings("unchecked")
  private void initialize(final AppModule appModuleParam, final RoomModule roomModuleParam,
      final Application applicationParam) {
    this.mainActivitySubcomponentFactoryProvider = new Provider<ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent.Factory>() {
      @Override
      public ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent.Factory get() {
        return new MainActivitySubcomponentFactory();}
    };
    this.provideHttpLoggingInterceptorProvider = DoubleCheck.provider(WeatherModule_ProvideHttpLoggingInterceptorFactory.create());
    this.provideOkHttpClientProvider = DoubleCheck.provider(WeatherModule_ProvideOkHttpClientFactory.create(provideHttpLoggingInterceptorProvider));
    this.provideWeatherApiProvider = DoubleCheck.provider(WeatherModule_ProvideWeatherApiFactory.create(provideOkHttpClientProvider));
    this.applicationProvider = InstanceFactory.create(applicationParam);
    this.provideAppRoomDatabaseProvider = DoubleCheck.provider(RoomModule_ProvideAppRoomDatabaseFactory.create(roomModuleParam, applicationProvider));
    this.appRoomHelperProvider = AppRoomHelper_Factory.create(provideAppRoomDatabaseProvider);
    this.provideRoomHelperProvider = DoubleCheck.provider(RoomModule_ProvideRoomHelperFactory.create(appRoomHelperProvider));
    this.factoryProvider = WeatherWorker_Factory_Factory.create(provideWeatherApiProvider, provideRoomHelperProvider);
    this.provideSchedulerProvider = DoubleCheck.provider(AppModule_ProvideSchedulerProviderFactory.create(appModuleParam));
    this.appWeatherRepositoryProvider = AppWeatherRepository_Factory.create(provideWeatherApiProvider);
    this.provideWeatherRepositoryProvider = DoubleCheck.provider(RoomModule_ProvideWeatherRepositoryFactory.create(appWeatherRepositoryProvider));
    this.provideDataManagerProvider = DoubleCheck.provider(RoomModule_ProvideDataManagerFactory.create(roomModuleParam, provideRoomHelperProvider, provideWeatherRepositoryProvider));
  }

  @Override
  public void inject(WeatherApp arg0) {
    injectWeatherApp(arg0);}

  @Override
  public AppWeatherWorkerFactory factory() {
    return new AppWeatherWorkerFactory(getMapOfClassOfAndProviderOfWeatherWorkerFactory());}

  private WeatherApp injectWeatherApp(WeatherApp instance) {
    DaggerApplication_MembersInjector.injectAndroidInjector(instance, getDispatchingAndroidInjectorOfObject());
    WeatherApp_MembersInjector.injectActivityDispatchingAndroidInjector(instance, getDispatchingAndroidInjectorOfActivity());
    WeatherApp_MembersInjector.injectFactory(instance, factory());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      return new DaggerAppComponent(new AppModule(), new RoomModule(), application);
    }
  }

  private final class MainActivitySubcomponentFactory implements ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent.Factory {
    @Override
    public ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent create(
        MainActivity arg0) {
      Preconditions.checkNotNull(arg0);
      return new MainActivitySubcomponentImpl(new ActivityModule(), arg0);
    }
  }

  private final class MainActivitySubcomponentImpl implements ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent {
    private Provider<MainViewModel> mainViewModelProvider;

    private Provider<LinearLayoutManager> provideLinearLayoutManagerProvider;

    private MainActivitySubcomponentImpl(ActivityModule activityModuleParam, MainActivity arg0) {

      initialize(activityModuleParam, arg0);
    }

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> getMapOfClassOfAndProviderOfViewModel(
        ) {
      return Collections.<Class<? extends ViewModel>, Provider<ViewModel>>singletonMap(MainViewModel.class, (Provider) mainViewModelProvider);}

    private ViewModelProviderFactory getViewModelProviderFactory() {
      return new ViewModelProviderFactory(getMapOfClassOfAndProviderOfViewModel());}

    @SuppressWarnings("unchecked")
    private void initialize(final ActivityModule activityModuleParam, final MainActivity arg0) {
      this.mainViewModelProvider = MainViewModel_Factory.create(DaggerAppComponent.this.provideSchedulerProvider, DaggerAppComponent.this.provideDataManagerProvider);
      this.provideLinearLayoutManagerProvider = DoubleCheck.provider(ActivityModule_ProvideLinearLayoutManagerFactory.create(activityModuleParam, (Provider) DaggerAppComponent.this.applicationProvider));
    }

    @Override
    public void inject(MainActivity arg0) {
      injectMainActivity(arg0);}

    private MainActivity injectMainActivity(MainActivity instance) {
      DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, DaggerAppComponent.this.getDispatchingAndroidInjectorOfObject());
      BaseActivity_MembersInjector.injectFactory(instance, getViewModelProviderFactory());
      MainActivity_MembersInjector.injectLayoutManager(instance, provideLinearLayoutManagerProvider.get());
      MainActivity_MembersInjector.injectAdapter(instance, new MainAdapter());
      return instance;
    }
  }
}
