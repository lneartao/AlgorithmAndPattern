package com.general.lneartao.lib.designpattern.templatemethod;

/**
 * Created by lneartao on 2017/11/24.
 */

public class App {
    public static void main(String[] args) {
        HalflingThief thief = new HalflingThief(new HitAndRunMethod());
        thief.steal();
        thief.changeMethod(new SubtleMethod());
        thief.steal();
    }
}
