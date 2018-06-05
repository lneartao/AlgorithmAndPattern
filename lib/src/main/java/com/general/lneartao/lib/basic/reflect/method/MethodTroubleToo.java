package com.general.lneartao.lib.basic.reflect.method;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * （这个例子也变相说明了Java可变参数的坑）
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class MethodTroubleToo {

    public void ping() {
        Logger.printl("PONG!");
    }

    public static void main(String[] args) {
//        spy("0");
//        spy("1");
//        spy("2");
        spy("3");
//        spy("4");
    }

    private static void spy(String... args) {
        try {
            MethodTroubleToo mtt = new MethodTroubleToo();
            Method m = MethodTroubleToo.class.getMethod("ping");
            switch (Integer.parseInt(args[0])) {
                case 0:
                    m.invoke(mtt);                  // works
                    break;
                case 1:
                    m.invoke(mtt, null);    // works，但是会有编译tix
                    break;
                case 2:
                    Object arg2 = null;             // IllegalArgumentException
                    m.invoke(mtt, arg2);
                    break;
                case 3:
                    m.invoke(mtt, new Object[0]);   // works
                    break;
                case 4:
                    Object arg4 = new Object[0];
                    m.invoke(mtt, arg4);            // IllegalArgumentException
                    break;
                default:
                    Logger.printl("Test not found");
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
