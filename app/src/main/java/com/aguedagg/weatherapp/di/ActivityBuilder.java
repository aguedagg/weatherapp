package com.aguedagg.weatherapp.di;

import com.aguedagg.weatherapp.di.module.ActivityModule;
import com.aguedagg.weatherapp.di.scope.ActivityScope;
import com.aguedagg.weatherapp.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = {ViewModelBuilder.class, ActivityModule.class})
    abstract MainActivity contributeMainActivity();
}
