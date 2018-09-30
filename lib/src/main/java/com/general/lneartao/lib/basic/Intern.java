package com.general.lneartao.lib.basic;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/6/12.
 */
public class Intern {
    public static void main(String[] args) {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        Logger.printl(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        Logger.printl(s3 == s4);

    }
}
