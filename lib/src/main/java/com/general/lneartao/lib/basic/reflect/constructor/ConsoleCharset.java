package com.general.lneartao.lib.basic.reflect.constructor;

import java.io.Console;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * 反射有两种创建实例的方式：Constructor.newInstance()和Class.newInstance()，推荐使用前者，理由如下：
 * Class.newInstance()只能invoke无参构造函数，Constructor.newInstance()可以invoke任意参数的构造函数 {@link ConstructorTrouble}
 * Class.newInstance()在构造函数会抛出受检或不受检异常，Constructor.newInstance()会把所有异常进行封装，然后抛出InvocationTargetException {@link ConstructorTroubleToo}
 * Class.newInstance()要求构造函数是可见的，Constructor.newInstance()可能在特定环境invoke私有的构造函数
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class ConsoleCharset {
    public static void main(String[] args) {
        Constructor[] ctors = Console.class.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0) {
                break;
            }
        }
        if (ctor != null) {
            try {
                ctor.setAccessible(true);
                Console console = (Console) ctor.newInstance();
                Field field = console.getClass().getDeclaredField("cs");
                field.setAccessible(true);
                System.out.printf("Console charset         :  %s%n", field.get(console));
                System.out.printf("Charset.defaultCharset():  %s%n", Charset.defaultCharset());

            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }
}
