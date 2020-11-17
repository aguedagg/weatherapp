package com.aguedagg.weatherapp.di.module;

import android.content.Context;

import com.aguedagg.weatherapp.di.scope.ActivityScope;

import androidx.recyclerview.widget.LinearLayoutManager;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @ActivityScope
    @Provides
    LinearLayoutManager provideLinearLayoutManager(Context context) {
        return new LinearLayoutManager(context);
    }
}
