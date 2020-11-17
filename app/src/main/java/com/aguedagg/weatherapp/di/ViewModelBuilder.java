package com.aguedagg.weatherapp.di;

import com.aguedagg.weatherapp.di.module.ViewModelProviderFactory;
import com.aguedagg.weatherapp.di.scope.AppScope;
import com.aguedagg.weatherapp.ui.MainViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    public abstract ViewModel bindMainViewModel(MainViewModel viewModel);


    @Binds
    @AppScope
    public abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelProviderFactory factory);
}
