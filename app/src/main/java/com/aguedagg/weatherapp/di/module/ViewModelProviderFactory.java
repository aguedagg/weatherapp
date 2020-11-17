package com.aguedagg.weatherapp.di.module;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelProviderFactory implements ViewModelProvider.Factory {

  private final Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

  @Inject
  public ViewModelProviderFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> creators) {
    this.creators = creators;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
    Provider<? extends ViewModel> creator = creators.get(modelClass);
    if (null == creator) {
      for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
        if (modelClass.isAssignableFrom(entry.getKey())) {
          creator = entry.getValue();
          break;
        }
      }
    }

    if (null == creator) {
      throw new IllegalArgumentException("Unknown model class " + modelClass);
    }

    try {
      return (T) creator.get();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
