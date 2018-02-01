package com.general.lneartao.lib.designpattern.prototype;

/**
 * Created by lneartao on 2017/11/14.
 */

public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
