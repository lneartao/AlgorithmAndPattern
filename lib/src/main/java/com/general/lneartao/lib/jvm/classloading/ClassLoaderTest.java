package com.general.lneartao.lib.jvm.classloading;

import com.general.lneartao.lib.Logger;

import java.io.IOException;
import java.io.InputStream;

/**
 * 不同的类加载器对instanceof关键字运算结果的影响
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filenName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(filenName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("com.general.lneartao.lib.jvm.classloading.ClassLoaderTest").newInstance();
        Logger.printl(obj.getClass());
        Logger.printl(obj instanceof ClassLoaderTest);
    }
}
