package com.general.lneartao.lib.designpattern.observer.ex2;

import com.general.lneartao.lib.Logger;

import java.util.Observable;
import java.util.Observer;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        Logger.printl("Current Conditions: ");
    }

    @Override
    public void update(Observable observable, Object o) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
