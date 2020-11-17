package com.aguedagg.weatherapp.databinding;
import com.aguedagg.weatherapp.R;
import com.aguedagg.weatherapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewholderDataBindingImpl extends ViewholderDataBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.guideline, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewholderDataBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ViewholderDataBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (androidx.constraintlayout.widget.Guideline) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[3]
            , (android.widget.ImageView) bindings[1]
            );
        this.humidity.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        this.temperature.setTag(null);
        this.weatherDescription.setTag(null);
        this.weatherIcon.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.aguedagg.weatherapp.data.City) variable);
        }
        else if (BR.constant == variableId) {
            setConstant((com.aguedagg.weatherapp.data.Constants) variable);
        }
        else if (BR.view == variableId) {
            setView((android.view.View) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.aguedagg.weatherapp.data.City Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }
    public void setConstant(@Nullable com.aguedagg.weatherapp.data.Constants Constant) {
        this.mConstant = Constant;
    }
    public void setView(@Nullable android.view.View View) {
        this.mView = View;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.aguedagg.weatherapp.data.City model = mModel;
        java.lang.String modelHumidity = null;
        java.util.List<com.aguedagg.weatherapp.data.City.WeatherData> modelWeatherData = null;
        com.aguedagg.weatherapp.data.City.WeatherData modelWeatherDataGetInt0 = null;
        java.lang.String modelWeatherDataGetInt0Description = null;
        java.lang.String modelWeatherDataGetInt0Icon = null;
        java.lang.String modelTemperature = null;
        java.lang.String modelCityName = null;

        if ((dirtyFlags & 0x9L) != 0) {



                if (model != null) {
                    // read model.humidity
                    modelHumidity = model.getHumidity();
                    // read model.weatherData
                    modelWeatherData = model.getWeatherData();
                    // read model.temperature
                    modelTemperature = model.getTemperature();
                    // read model.cityName
                    modelCityName = model.getCityName();
                }


                if (modelWeatherData != null) {
                    // read model.weatherData.get(0)
                    modelWeatherDataGetInt0 = modelWeatherData.get(0);
                }


                if (modelWeatherDataGetInt0 != null) {
                    // read model.weatherData.get(0).description
                    modelWeatherDataGetInt0Description = modelWeatherDataGetInt0.getDescription();
                    // read model.weatherData.get(0).icon
                    modelWeatherDataGetInt0Icon = modelWeatherDataGetInt0.getIcon();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x9L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.humidity, modelHumidity);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, modelCityName);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.temperature, modelTemperature);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.weatherDescription, modelWeatherDataGetInt0Description);
            com.aguedagg.weatherapp.data.City.getIcon(this.weatherIcon, modelWeatherDataGetInt0Icon);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model
        flag 1 (0x2L): constant
        flag 2 (0x3L): view
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}