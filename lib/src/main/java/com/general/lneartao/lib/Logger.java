package com.general.lneartao.lib;

import java.util.Collection;

/**
 * Created by lneartao on 2017/11/13.
 */

public class Logger {
    public static void printl(String x) {
        System.out.println(x);
    }

    public static void printl(int x) {
        System.out.println(x);
    }

    public static void printl(char x) {
        System.out.println(x);
    }

    public static void printl(boolean x) {
        System.out.println(x);
    }

    public static void printl(float x) {
        System.out.println(x);
    }

    public static void printl(double x) {
        System.out.println(x);
    }

    public static void printl(int[] x) {
        for (Integer num : x) {
            System.out.print(num);
            System.out.println();
        }
        System.out.println();
    }

    public static void printl(double[] x) {
        for (Double num : x) {
            System.out.print(num);
        }
        System.out.println();
    }


    public static void printl(Collection<Integer> x) {
        for (Integer i : x) {
            System.out.print(i);
        }
        System.out.println();
    }
}
