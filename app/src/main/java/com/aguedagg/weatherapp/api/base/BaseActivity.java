package com.aguedagg.weatherapp.api.base;

import android.os.Bundle;

import com.aguedagg.weatherapp.di.module.ViewModelProviderFactory;

import javax.inject.Inject;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
        extends DaggerAppCompatActivity  {

    @Inject
    ViewModelProviderFactory factory;

    private T viewDataBinding;
    private V viewModel;

    protected abstract @LayoutRes
    int getLayoutId();

    public abstract V getViewModel();

    public abstract int getBindingVariable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setDataBinding();
    }

    private void setDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.viewModel = viewModel == null ? getViewModel() : viewModel;
        viewDataBinding.setVariable(getBindingVariable(), viewModel);
        viewDataBinding.executePendingBindings();
    }

    public T getViewDataBinding() {
        return viewDataBinding;
    }

    public ViewModelProviderFactory getFactory() {
        return factory;
    }

}
