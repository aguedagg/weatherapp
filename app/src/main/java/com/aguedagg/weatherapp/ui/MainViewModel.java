package com.aguedagg.weatherapp.ui;

import android.util.Log;

import com.aguedagg.weatherapp.api.base.BaseViewModel;
import com.aguedagg.weatherapp.api.base.rx.SchedulerProvider;
import com.aguedagg.weatherapp.data.City;
import com.aguedagg.weatherapp.data.DataManager;
import com.aguedagg.weatherapp.data.WeatherResponse;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.functions.Consumer;

public class MainViewModel extends BaseViewModel {

    private MutableLiveData<AuthResource<List<City>>> source = new MutableLiveData<>();

    @Inject
    public MainViewModel(SchedulerProvider provider, DataManager appDataManager) {
        super(provider, appDataManager);
        getLocalRepo();
    }

    @Override
    public void setError(Throwable e) {
        source.setValue(AuthResource.error(e.getMessage()));
    }

    LiveData<AuthResource<List<City>>> getSource() {
        return source;
    }

    void getOnlineRepo() {
        getCompositeDisposable().add(getDataManager().getRepo()
                .doOnSubscribe(disposable -> doOnLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(weatherModels -> {
                    insertIntoRoom(weatherModels.getCities());
                }).doOnError(this::setError)
                .subscribe(response -> { }, throwable -> {
                    doOnError();
                }));
    }

    void getLocalRepo() {
        getCompositeDisposable().add(getDataManager().getRoomRepo()
                .doOnSubscribe(disposable -> doOnLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnSuccess(weatherModels -> {
                    if (weatherModels.isEmpty()) {
                        getOnlineRepo();
                    } else {
                        source.setValue(AuthResource.success(weatherModels));
                    }
                }).doOnError(this::setError)
                .subscribe());
    }

    private void insertIntoRoom(List<City> list) {
            getCompositeDisposable().add(getDataManager().insert(list)
                .doOnSubscribe(disposable -> doOnLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnComplete(this::getLocalRepo)
                .doOnError(this::setError)
                .subscribe());
    }

    private void deleteEntries() {
        getCompositeDisposable().add(getDataManager().deleteAll()
                .doOnSubscribe(disposable -> doOnLoading())
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .doOnComplete(this::getOnlineRepo).doOnError(this::setError)
                .subscribe());
    }

    private void doOnLoading() {
        source.postValue(AuthResource.loading(null));
    }

    private void doOnError() {
        source.postValue(AuthResource.error("Network error"));
    }

}
