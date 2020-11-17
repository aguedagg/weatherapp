package com.aguedagg.weatherapp.data;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.widget.ImageView;

import com.aguedagg.weatherapp.R;
import com.aguedagg.weatherapp.data.model.WeatherConverter;
import com.aguedagg.weatherapp.di.module.GlideApp;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class City {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String mCityName;

    //@TypeConverters(MainConverter.class)
    //@SerializedName("main")
    //private MainData mMainData;

    @SerializedName("main")
    @JsonAdapter(TemperatureDeserializer.class)
    private String temperature;

    @TypeConverters(WeatherConverter.class)
    @SerializedName("weather")
    private List<WeatherData> mWeatherData;

    public City() {
    }

    public City(@NonNull String id, String name) {
        this.id = id;
        this.mCityName = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String name) {
        this.mCityName = name;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        // TODO: remove hardcode, investigate serialization
        return "34%";//wd.getDescription();
    }

    public List<WeatherData> getWeatherData() {
        return mWeatherData;
    }

    public void setWeatherData(List<WeatherData> mWeatherData) {
        this.mWeatherData = mWeatherData;
    }

    /*public MainData getMainData() {
        return mMainData;
    }

    public void setMainData(MainData mMainData) {
        this.mMainData = mMainData;
    }*/

    /*
    "main": {
        "temp": 282.55,
        "feels_like": 281.86,
        "temp_min": 280.37,
        "temp_max": 284.26,
        "pressure": 1023,
        "humidity": 100
     */
    public static class MainData {
        @SerializedName("temp")
        private String mTemperature;
        @SerializedName("pressure")
        private String mPressure;
        @SerializedName("humidity")
        private String mHumidity;

        public String getTemperature() {
            return mTemperature;
        }

        public void setTemperature(String temp) {
            this.mTemperature = temp;
        }

        public String getPressure() {
            return mPressure;
        }

        public void setPressure(String pressure) {
            this.mPressure = pressure;
        }

        public String getHumidity() {
            return mHumidity;
        }

        public void setHumidity(String humidity) {
            this.mHumidity = humidity;
        }
    }

    /*
    "weather": [
    {
      "id": 800,
      "main": "Clear",
      "description": "clear sky",
      "icon": "01d"
    }]
    */
    public class WeatherData {
        @SerializedName("description")
        private String mDescription;
        @SerializedName("icon")
        private String mIcon;

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            this.mDescription = description;
        }

        public String getIcon() {
            return mIcon;
        }

        public void setIcon(String icon) {
            this.mIcon = mIcon;
        }
    }

    public static class TemperatureDeserializer implements JsonDeserializer<String> {
        @Override
        public String deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
            return json.getAsJsonObject().get("temp").getAsString();
        }
    }

    @BindingAdapter({"imagePath"})
    public static void getIcon(ImageView imageView, String path) {
        path = Constants.BASE_URL_IMAGE + path + "@2x.png";
        GlideApp.with(imageView.getContext())
                .load(path)
                .centerCrop()
                .placeholder(new ColorDrawable(Color.BLACK))
                .error(new ColorDrawable(Color.RED))
                .fallback(new ColorDrawable(Color.GRAY))
                .apply(RequestOptions.circleCropTransform())
                .into(imageView);
    }
}