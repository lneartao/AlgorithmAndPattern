package com.general.lneartao.lib.designpattern.observer.generic;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.designpattern.observer.WeatherType;

/**
 * Created by lneartao on 2017/11/27.
 */

public class GWeather extends Observable<GWeather, Race, WeatherType> {
    private WeatherType currentWeather;

    public GWeather() {
        currentWeather = WeatherType.SUNNY;
    }

    /**
     * Makes time pass for weather
     */
    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        currentWeather = enumValues[(currentWeather.ordinal() + 1) % enumValues.length];
        Logger.printl("The weather changed to " + currentWeather);
        notifyObservers(currentWeather);
    }
}
