package com.general.lneartao.lib.designpattern.observer;

/**
 * Created by lneartao on 2017/11/27.
 */

public enum WeatherType {
    SUNNY, RAINY, WINDY, COLD;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
