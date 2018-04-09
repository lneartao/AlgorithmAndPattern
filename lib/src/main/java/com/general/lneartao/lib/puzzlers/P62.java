package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * 1、IdentityHashMap使用的是引用等价性而不是值等价性 所以A==B，才会认为是相等的
 * 2、语言规范保证了字符串是内存限定的，因此相等的字符串常量同时也是相同的，即String1 == String2，且String1.equals(String2)
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P62 {
    public static void main(String[] args) {
        Map<String, String> m = new IdentityHashMap<>();
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
        Logger.printl(m.size());
    }
}
