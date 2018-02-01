package com.general.lneartao.lib.designpattern.observer;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/27.
 */

public class Orcs implements WeatherObserver {
    public Orcs() {
    }

    @Override
    public void update(WeatherType type) {
        switch (type) {
            case COLD:
                Logger.printl("The Orcs are freezing cold");
                break;
            case RAINY:
                Logger.printl("The Orcs are dripping wet.");
                break;
            case SUNNY:
                Logger.printl("The sun hurts the orcs' eyes.");
                break;
            case WINDY:
                Logger.printl("The Orc smell almost vanishes in the wind.");
                break;
            default:
                break;
        }
    }
}
