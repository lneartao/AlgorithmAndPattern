package com.general.lneartao.lib.designpattern.observer.generic;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.designpattern.observer.WeatherType;

/**
 * Created by lneartao on 2017/11/27.
 */

public class GOrcs implements Race {

    @Override
    public void update(GWeather subject, WeatherType argument) {
        switch (argument) {
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
