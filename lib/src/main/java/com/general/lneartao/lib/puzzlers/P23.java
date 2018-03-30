package com.general.lneartao.lib.puzzlers;

import java.util.Random;

/**
 * 这里有三个错误
 * 1、栅栏错误，界限端点的问题
 * 2、switch的每个case漏掉了break
 * 3、StringBuffer的构造器
 * 但是IDE的提醒还是比较清楚的
 *
 * @author lneartao
 * @date 2018/3/29.
 */

public class P23 {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        wrongOne();
        correctOne();
        commonOne();
    }

    private static void commonOne() {
        String[] a = {"Main", "Pain", "Gain"};
        System.out.println(randomElement(a));
    }

    private static String randomElement(String[] a) {
        return a[rnd.nextInt(a.length)];
    }

    private static void correctOne() {
        System.out.println("PGM".charAt(rnd.nextInt(3)) + "ain");
    }

    private static void wrongOne() {
        StringBuffer word = null;
        switch (rnd.nextInt(2)) {
            case 1:
                word = new StringBuffer('P');
            case 2:
                word = new StringBuffer('G');
            default:
                word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }
}
