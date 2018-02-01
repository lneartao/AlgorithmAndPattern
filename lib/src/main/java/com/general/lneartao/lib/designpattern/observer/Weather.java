package com.general.lneartao.lib.designpattern.observer;

import com.general.lneartao.lib.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lneartao on 2017/11/27.
 */

public class Weather {
    private WeatherType mWeatherType;
    private List<WeatherObserver> mWeatherObservers;

    public Weather() {
        mWeatherObservers = new ArrayList<>();
        mWeatherType = WeatherType.SUNNY;
    }

    public void addObserver(WeatherObserver weatherObserver) {
        mWeatherObservers.add(weatherObserver);
    }

    public void removeObserver(WeatherObserver weatherObserver) {
        mWeatherObservers.remove(weatherObserver);
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();
        mWeatherType = enumValues[(mWeatherType.ordinal() + 1) % enumValues.length];
        Logger.printl("The weather changed to " + mWeatherType);
        notifyObservers();
    }

    private void notifyObservers() {
        for (WeatherObserver observer : mWeatherObservers) {
            observer.update(mWeatherType);
        }
    }
}
