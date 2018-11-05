package com.general.lneartao.lib.designpattern.observer;

import com.general.lneartao.lib.designpattern.observer.generic.GHobbits;
import com.general.lneartao.lib.designpattern.observer.generic.GOrcs;
import com.general.lneartao.lib.designpattern.observer.generic.GWeather;

/**
 * 观察者模式：定义了对象之间的一对多依赖，这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并自动更新
 * Created by lneartao on 2017/11/27.
 */

public class App {
    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new Orcs());
        weather.addObserver(new Hobbits());
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();
        weather.timePasses();

        GWeather gWeather = new GWeather();
        gWeather.addObserver(new GOrcs());
        gWeather.addObserver(new GHobbits());

        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
        gWeather.timePasses();
    }
}
