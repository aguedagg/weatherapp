package com.aguedagg.weatherapp.data;

public class Constants {

  public static final int WORK_INTERVAL_MINUTES = 1;

  // Open Weather
  public static final String BASE_URL = "http://api.openweathermap.org/";
  public static final String REST_CONSTANT = "data/2.5/find";
  public static final String BASE_URL_IMAGE = "http://openweathermap.org/img/wn/";

  public static final String API_KEY = "6085c161d697ac13a61ef7c87cf52cbe";
  public static final String UNITS = "metric";
  public static final int NUM_RESULTS = 10;
  // For this task, take Toronto coordinates. Ideally, get coordinates from location API
  public static final String TORONTO_LAT = "43.6532";
  public static final String TORONTO_LON = "-79.3832";

  private static final String FIELD_ERROR = "Error";
  public static final String ROOM_DB = "city.db";
  public String getError() {return FIELD_ERROR;}
}
