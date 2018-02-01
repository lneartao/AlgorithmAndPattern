package com.general.lneartao.lib.designpattern.observer;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/27.
 */

public class Hobbits implements WeatherObserver {
    public Hobbits() {
    }

    @Override
    public void update(WeatherType type) {
        switch (type) {
            case WINDY:
                Logger.printl("The hobbits are shivering in the cold weather.");
                break;
            case SUNNY:
                Logger.printl("The happy hobbits bade in the warm sun.");
                break;
            case RAINY:
                Logger.printl("The hobbits look for cover from the rain.");
                break;
            case COLD:
                Logger.printl("THe hobbits hold their hats tightly in the windy weather.");
                break;
            default:
                break;
        }
    }
}
