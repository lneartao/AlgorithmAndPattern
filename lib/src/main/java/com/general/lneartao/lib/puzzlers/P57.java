package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * 为了允许Hashset、HashTable等hash集合能添加处理自定义类不出问题，当你重写equals方法时，一定要记得重写hashCode方法
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P57 {
    public static void main(String[] args) {
        Set s = new HashSet();
        s.add(new P57("tao", "zhang"));
        Logger.printl(s.contains(new P57("tao", "zhang")));
    }

    private String first, last;

    public P57(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof P57) {
            return true;
        }
        if (obj == this) {
            return true;
        }
        P57 n = (P57) obj;
        return n.first.equals(first) && n.last.equals(last);
    }

    /*@Override
    public int hashCode() {
        return 37 * first.hashCode() + last.hashCode();
    }*/
}
