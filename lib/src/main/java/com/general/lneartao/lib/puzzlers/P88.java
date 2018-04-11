package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * 这里要理解泛型接口、参数化类型和原生类型
 * 如List<E>是一个泛型接口，List<String>是一个参数化的类型，而List就是一个原生类型
 * 原生类型的所有实例方法都要执行类型擦除
 *
 * @author lneartao
 * @date 2018/4/10.
 */
public class P88<T> {
    private final T first;
    private final T second;

    public P88(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public List<String> stringList() {
        return Arrays.asList(String.valueOf(first), String.valueOf(second));
    }

    public static void main(String[] args) {
//        P88 pair = new P88<Object>(23, "skidoo");
        // 修正
        P88<Object> pair = new P88<>(23, "skidoo");
        Logger.printl(pair.getFirst() + " " + pair.getSecond());
        for (String s : pair.stringList()) {
            Logger.printl(s);
        }
    }
}
