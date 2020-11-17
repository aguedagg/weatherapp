package com.aguedagg.weatherapp.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Replacement scope for {@link javax.inject.Singleton}
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface AppScope {
}
