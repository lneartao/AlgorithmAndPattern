package com.general.lneartao.lib.designpattern.adapter;

/**
 * 适配器模式
 * Created by lneartao on 2017/11/13.
 */

public class App {
    public static void main(String[] args) {
        Captain captain = new Captain(new FishingBoatAdapter());
        captain.row();
    }
}
