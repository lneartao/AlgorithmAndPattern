package com.general.lneartao.lib.effectivejava.r5.i39;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lneartao
 * @date 2020/1/19.
 */
public class Sample3 {
    @Exception2Test(IndexOutOfBoundsException.class)
    @Exception2Test(NullPointerException.class)
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }
}
