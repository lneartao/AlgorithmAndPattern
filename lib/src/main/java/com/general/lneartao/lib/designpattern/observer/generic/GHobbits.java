package com.general.lneartao.lib.designpattern.observer.generic;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.designpattern.observer.WeatherType;

/**
 * Created by lneartao on 2017/11/27.
 */

public class GHobbits implements Race {
    @Override
    public void update(GWeather subject, WeatherType argument) {
        switch (argument) {
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
