package com.general.lneartao.lib.designpattern.singleton;

/**
 * @author lneartao
 * @date 2018/11/7.
 */
public class ChocolateBoilerEager {

    private static ChocolateBoilerEager INSTANCE = new ChocolateBoilerEager();
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerEager() {
        empty = true;
        boiled = false;
    }

    public static ChocolateBoilerEager getINSTANCE() {
        return INSTANCE;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // do something

        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // do something

            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // do something

            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
