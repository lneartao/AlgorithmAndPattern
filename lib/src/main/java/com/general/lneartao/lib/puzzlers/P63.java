package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lneartao
 * @date 2018/4/9.
 */
public class P63 {
    private Map<String, String> m = new HashMap<>();

    /**
     * 因为这个不是构造方法，差点被它骗了
     */
    public void P63() {
        m.put("Mickey", "Mouse");
        m.put("Mickey", "Mantle");
    }

    public int size() {
        return m.size();
    }

    public static void main(String[] args) {
        P63 p63 = new P63();
        Logger.printl(p63.size());
    }
}
