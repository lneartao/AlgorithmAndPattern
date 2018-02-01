package com.general.lneartao.lib.designpattern.state;

/**
 * Created by lneartao on 2017/12/4.
 */

public class App {
    public static void main(String[] args) {
        Mammoth mammoth = new Mammoth();
        mammoth.observe();
        mammoth.timePasses();
        mammoth.observe();
        mammoth.timePasses();
        mammoth.observe();
    }
}
