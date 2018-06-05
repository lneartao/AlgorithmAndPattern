package com.general.lneartao.lib.basic.reflect.enumerated;

import java.lang.reflect.Field;

/**
 * @author lneartao
 * @date 2018/6/4.
 */
public class SetTrace {

    public static void main(String[] args) {
        trace("OFF");
        trace("DEBUG");
    }

    private static void trace(String level) {
        TraceLevel newLevel = TraceLevel.valueOf(level);
        try {
            MyServer svr = new MyServer();
            Class<?> c = svr.getClass();
            Field f = c.getDeclaredField("level");
            f.setAccessible(true);
            TraceLevel oldLevel = (TraceLevel) f.get(svr);
            System.out.printf("Original trace level: %s%n", oldLevel);

            if (oldLevel != newLevel) {
                f.set(svr, newLevel);
                System.out.printf("    New  trace level: %s%n", f.get(svr));
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

enum TraceLevel {
    OFF, LOW, MEDIUM, HIGH, DEBUG
}

class MyServer {
    private TraceLevel level = TraceLevel.OFF;
}