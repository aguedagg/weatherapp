package com.aguedagg.weatherapp.data.dao;

import android.database.Cursor;
import androidx.room.EmptyResultSetException;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.RxRoom;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.aguedagg.weatherapp.data.City;
import com.aguedagg.weatherapp.data.model.WeatherConverter;
import io.reactivex.Completable;
import io.reactivex.Single;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.Void;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WeatherModelDao_Impl implements WeatherModelDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<City> __insertionAdapterOfCity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public WeatherModelDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCity = new EntityInsertionAdapter<City>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `City` (`id`,`mCityName`,`temperature`,`mWeatherData`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, City value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getId());
        }
        if (value.getCityName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getCityName());
        }
        if (value.getTemperature() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getTemperature());
        }
        final String _tmp;
        _tmp = WeatherConverter.convertToString(value.getWeatherData());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM city";
        return _query;
      }
    };
  }

  @Override
  public Completable insert(final List<City> weatherModel) {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfCity.insert(weatherModel);
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
        }
      }
    });
  }

  @Override
  public Completable deleteAll() {
    return Completable.fromCallable(new Callable<Void>() {
      @Override
      public Void call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return null;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    });
  }

  @Override
  public Single<List<City>> getAllEntries() {
    final String _sql = "SELECT * from city";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return RxRoom.createSingle(new Callable<List<City>>() {
      @Override
      public List<City> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfMCityName = CursorUtil.getColumnIndexOrThrow(_cursor, "mCityName");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfMWeatherData = CursorUtil.getColumnIndexOrThrow(_cursor, "mWeatherData");
          final List<City> _result = new ArrayList<City>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final City _item;
            _item = new City();
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            _item.setId(_tmpId);
            final String _tmpMCityName;
            _tmpMCityName = _cursor.getString(_cursorIndexOfMCityName);
            _item.setCityName(_tmpMCityName);
            final String _tmpTemperature;
            _tmpTemperature = _cursor.getString(_cursorIndexOfTemperature);
            _item.setTemperature(_tmpTemperature);
            final List<City.WeatherData> _tmpMWeatherData;
            final String _tmp;
            _tmp = _cursor.getString(_cursorIndexOfMWeatherData);
            _tmpMWeatherData = WeatherConverter.convertToList(_tmp);
            _item.setWeatherData(_tmpMWeatherData);
            _result.add(_item);
          }
          if(_result == null) {
            throw new EmptyResultSetException("Query returned empty result set: " + _statement.getSql());
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
