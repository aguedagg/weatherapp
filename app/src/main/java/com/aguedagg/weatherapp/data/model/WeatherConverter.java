package com.aguedagg.weatherapp.data.model;

import com.aguedagg.weatherapp.data.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class WeatherConverter {

    @TypeConverter
    public static List<City.WeatherData> convertToList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type type = new TypeToken<List<City.WeatherData>>() {
        }.getType();
        return new Gson().fromJson(data, type);
    }

    @TypeConverter
    public static String convertToString(List<City.WeatherData> list) {
        return new Gson().toJson(list);
    }

}
