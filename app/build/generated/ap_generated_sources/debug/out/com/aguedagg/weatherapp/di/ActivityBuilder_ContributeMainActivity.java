package com.aguedagg.weatherapp.di;

import com.aguedagg.weatherapp.di.module.ActivityModule;
import com.aguedagg.weatherapp.di.scope.ActivityScope;
import com.aguedagg.weatherapp.ui.MainActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjectionKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilder_ContributeMainActivity.MainActivitySubcomponent.class)
public abstract class ActivityBuilder_ContributeMainActivity {
  private ActivityBuilder_ContributeMainActivity() {}

  @Binds
  @IntoMap
  @AndroidInjectionKey("com.aguedagg.weatherapp.ui.MainActivity")
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      MainActivitySubcomponent.Factory builder);

  @Subcomponent(modules = {ViewModelBuilder.class, ActivityModule.class})
  @ActivityScope
  public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {}
  }
}
