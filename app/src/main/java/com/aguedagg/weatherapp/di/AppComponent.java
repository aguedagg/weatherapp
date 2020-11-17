package com.aguedagg.weatherapp.di;

import android.app.Application;

import com.aguedagg.weatherapp.WeatherApp;
import com.aguedagg.weatherapp.di.module.AppModule;
import com.aguedagg.weatherapp.di.module.WorkerModule;
import com.aguedagg.weatherapp.di.scope.AppScope;
import com.aguedagg.weatherapp.service.AppWeatherWorkerFactory;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@AppScope
@Component(modules = {AppContextModule.class, AppModule.class,
        AndroidSupportInjectionModule.class, ActivityBuilder.class, WorkerModule.class})
public interface AppComponent extends AndroidInjector<WeatherApp> {

    AppWeatherWorkerFactory factory();

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
