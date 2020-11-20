package com.aguedagg.weatherapp.data.model;

import com.aguedagg.weatherapp.data.City;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;

public class MainConverter {

    @TypeConverter
    public static City.MainData convertToList(String data) {
        if (data == null) {
            return new City.MainData();
        }
        Type type = new TypeToken<City.MainData>() {
        }.getType();
        return new Gson().fromJson(data, type);
    }

    @TypeConverter
    public static String convertToString(City.MainData list) {
        return new Gson().toJson(list);
    }

}
