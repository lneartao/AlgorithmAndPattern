package com.general.lneartao.lib.puzzlers.p44;

import com.general.lneartao.lib.Logger;

/**
 * 要想编写一个能够探测出某个类是否丢失的程序，请使用反射来引用类而不要使用通常的语言结构
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class Strange {
    public static void main(String[] args) throws Exception {
        try {
            Object m = Class.forName("Missing").newInstance();
        } catch (ClassNotFoundException ex) {
            Logger.printl("Got it!");
        }
    }
}
