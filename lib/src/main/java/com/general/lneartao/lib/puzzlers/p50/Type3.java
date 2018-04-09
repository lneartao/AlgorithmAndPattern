package com.general.lneartao.lib.puzzlers.p50;

/**
 * 这个会报ClassCastException
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Type3 {
    public static void main(String[] args) {
        Type3 t3 = (Type3) new Object();
    }
}
