package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 这个还是隐藏的问题
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P79 {
    public final String name;
    public final String food;
    public final String sound;

    public P79(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
    }

    public void eat() {
        Logger.printl(name + ": Mmmmm, " + food);
    }

    public void play() {
        Logger.printl(name + ": " + sound + " " + sound);
    }

    public void sleep() {
        Logger.printl(name + ": Zzzzzz...");
    }

    public void live() {
//        new Thread() {
//            @Override
//            public void run() {
//                while (true) {
//                    eat();
//                    play();
////                    sleep();
//                    P79.this.sleep();
//                }
//            }
//        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    eat();
                    play();
                    sleep();
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        new P79("Fido", "Beef", "Woof").live();
    }
}
