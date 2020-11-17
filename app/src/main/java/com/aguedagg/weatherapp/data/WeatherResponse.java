package com.aguedagg.weatherapp.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class WeatherResponse {

   /*
       "message": "accurate",
       "cod": "200",
       "count": 10,
       "list": []
   */

    @SerializedName("message")
    private String message;

    @SerializedName("list")
    private List<City> cities = new ArrayList<City>();

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public List<City> getCities() { return cities; }

    public void setCities(List<City> cities) { this.cities = cities; }

}
