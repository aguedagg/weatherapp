package com.aguedagg.weatherapp.api.base;

import com.aguedagg.weatherapp.api.base.rx.AppSchedulerProvider;
import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import com.aguedagg.weatherapp.data.AppDataManager;
import com.aguedagg.weatherapp.data.DataManager;

import javax.inject.Inject;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    @Inject
    DataManager dataManager;
    @Inject
    SchedulerProvider schedulerProvider;
    private final CompositeDisposable compositeDisposable;

    /**
     * Instantiates a new Base view model.
     *
     * @param provider {@link AppSchedulerProvider} the provider
     * @param manager  {@link AppDataManager}the manager
     */
    public BaseViewModel(SchedulerProvider provider, DataManager manager) {
        this.compositeDisposable = new CompositeDisposable();
        this.schedulerProvider = provider;
        this.dataManager = manager;
    }

    public abstract void setError(Throwable e);

    protected CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    protected DataManager getDataManager() {
        return dataManager;
    }

    protected SchedulerProvider getSchedulerProvider() {
        return schedulerProvider;
    }

    @Override
    protected void onCleared() {
        if (getCompositeDisposable() != null) {
            getCompositeDisposable().dispose();
        }
        super.onCleared();
    }
}
