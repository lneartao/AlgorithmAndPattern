package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 这里有一个现象：所有的本地的、内部的、嵌套的和匿名的类都可以毫无限制地访问彼此的成员
 * 你发现getName()的访问修饰符不一样后会有不一样的结果，因为私有成员不会被继承
 *
 *
 * @author lneartao
 * @date 2018/4/11.
 */
public class P92 {
    private final String name;

    public P92(String name) {
        this.name = name;
    }

    /*public String getName() {
        return name;
    }*/

    private String getName() {
        return name;
    }

    private void reproduce() {
        new P92("reproduce") {
            void printName() {
                Logger.printl(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new P92("main").reproduce();
    }
}
