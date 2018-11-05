package com.general.lneartao.lib.designpattern.strategy.ex2;

/**
 * @author lneartao
 * @date 2018/11/2.
 */
public class Troll extends Character {

    public Troll() {
        weaponBehavior = new KnifeBehavior();
    }
}
