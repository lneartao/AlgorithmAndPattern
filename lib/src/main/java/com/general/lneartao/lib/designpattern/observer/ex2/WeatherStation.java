package com.general.lneartao.lib.designpattern.observer.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasurements(90, 23, 30.4f);
        weatherData.setMeasurements(44, 33, 30.4f);
    }
}
