package com.general.lneartao.lib.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lneartao on 2017/11/29.
 */

public class Foo {
    public static void main(String[] args) {
        String x = new String("ab");
        change(x);
        System.out.println(x);

        Integer y = new Integer(5);
        change(y);
        System.out.println(y);

        List<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(4);
        change(a);

        System.out.println(a);

    }

    public static void change(String x) {
        x = "cd";
    }

    public static void change(Integer y) {
        y = 4;
    }

    public static void change(List<Integer> a) {
//        a.add(5);
        a = new ArrayList<>();
        a.add(2);

    }

}
