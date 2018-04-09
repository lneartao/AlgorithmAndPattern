package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * 造成这个bug的原因是012，以0开头的整数类型字面常量将被解释成八进制数值，此处为10
 * 提醒：千万不要在一个整数字面常量的前面加一个0，这会使它变成一个八进制字面常量
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P59 {
    public static void main(String[] args) {
        int vals[] = {789, 678, 567, 456, 345, 234, 123, 012};
        Set diffs = new HashSet();
        for (int i = 0; i < vals.length; i++) {
            for (int j = i; j < vals.length; j++) {
                diffs.add(vals[i] - vals[j]);
            }
        }
        Logger.printl(diffs.size());
    }
}
