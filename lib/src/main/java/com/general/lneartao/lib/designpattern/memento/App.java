package com.general.lneartao.lib.designpattern.memento;

import com.general.lneartao.lib.Logger;

import java.util.Stack;

/**
 * 备忘录模式
 * Created by lneartao on 2017/12/1.
 */

public class App {
    public static void main(String[] args) {
        Stack<StarMemento> stars = new Stack<>();
        Star star = new Star(10000000, 50000, StarType.SUN);
        Logger.printl(star.toString());
        stars.add(star.getMemento());
        star.timePasses();
        Logger.printl(star.toString());
        stars.add(star.getMemento());
        star.timePasses();
        Logger.printl(star.toString());
        stars.add(star.getMemento());
        star.timePasses();
        Logger.printl(star.toString());
        stars.add(star.getMemento());
        star.timePasses();
        Logger.printl(star.toString());
        while (stars.size() > 0) {
            star.setMemento(stars.pop());
            Logger.printl(star.toString());
        }
    }
}
