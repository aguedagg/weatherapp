package com.aguedagg.weatherapp.api.base.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {

  Scheduler computation();

  Scheduler io();

  Scheduler ui();
}
