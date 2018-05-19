package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/5/18.
 */
public class GenericTypes {
//    public static String method(List<String> list) {
//        Logger.printl("invoke method(List<String> list)");
//        return "";
//    }

    public static int method(List<Integer> list) {
        Logger.printl("invoke method(List<Integer> list");
        return 1;
    }

    public static void main(String[] args) {
//        method(new ArrayList<String>());
        method(new ArrayList<Integer>());
    }
}
