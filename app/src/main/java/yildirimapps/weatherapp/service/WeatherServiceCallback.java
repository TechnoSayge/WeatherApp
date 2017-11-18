package yildirimapps.weatherapp.service;

import yildirimapps.weatherapp.data.Channel;

/**
 * Created by hmy on 10/12/2017.
 */

public interface WeatherServiceCallback {

    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
