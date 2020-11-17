package com.aguedagg.weatherapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.aguedagg.weatherapp.R;
import com.aguedagg.weatherapp.api.base.BaseActivity;
import com.aguedagg.weatherapp.databinding.ActivityMainBinding;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Inject
    LinearLayoutManager layoutManager;

    @Inject
    MainAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainViewModel getViewModel() {
        return new ViewModelProvider(this, getFactory()).get(MainViewModel.class);
    }

    @Override
    public int getBindingVariable() {
        return com.aguedagg.weatherapp.BR.mainViewModel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initObservers();
    }

    private void initView() {
        initRecyclerview();
        getViewDataBinding().content.loadingIndicator.setVisibility(View.VISIBLE);
    }

    private void initRecyclerview() {
        getViewDataBinding().content.containerRc.setHasFixedSize(true);
        getViewDataBinding().content.containerRc.setLayoutManager(layoutManager);
        getViewDataBinding().content.containerRc.setAdapter(adapter);
    }

    private void initObservers() {
        observeData();
    }

    private void observeData() {
        getViewModel().getSource().observe(this, listAuthResource -> {
            Log.e("MainActivity", "observed " + listAuthResource.status);
            if (listAuthResource != null) {
                switch (listAuthResource.status) {
                    case LOADING:
                        adapter.setEmptySource();
                        showLoading();
                        break;
                    case SUCCESS:
                        adapter.setSource(listAuthResource.data);
                        hideLoading();
                        break;
                    case ERROR:
                        // TODO: show error layout
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void showLoading() {
        getViewDataBinding().content.loadingIndicator.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        getViewDataBinding().content.loadingIndicator.setVisibility(View.GONE);
    }
}

