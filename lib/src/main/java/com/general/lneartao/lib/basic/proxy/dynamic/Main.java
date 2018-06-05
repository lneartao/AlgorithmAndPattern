package com.general.lneartao.lib.basic.proxy.dynamic;

import com.general.lneartao.lib.basic.proxy.util.ProxyUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 实现动态代理的步骤
 * 1、新建委托类 {@link OperateImpl}，动态代理要求委托类必须实现某个接口 {@link Operate}
 * 2、实现InvocationHandler接口，这是负责连接代理类和委托类的中间类必须实现的接口 {@link TimingInvocationHandler}
 * 3、通过Proxy类新建代理对象
 *
 * @author lneartao
 * @date 2018/5/31.
 */
public class Main {

    public static void main(String[] args) {
        TimingInvocationHandler timingInvocationHandler = new TimingInvocationHandler(new OperateImpl());
        Operate operate = (Operate) Proxy.newProxyInstance(Operate.class.getClassLoader(), new Class[]{Operate.class}, timingInvocationHandler);

        // call method of proxy instance
        operate.operateMethod1();
        operate.operateMethod2();
        operate.operateMethod3(100);

        // print info of proxy class
        System.out.println("proxy class is: " + operate.getClass().getName());
        System.out.println("\r\nsuper class of proxy class is: " + operate.getClass().getSuperclass().getName());
        System.out.println("\r\ninterfaces of proxy class are: ");
        for (Class inter : operate.getClass().getInterfaces()) {
            System.out.println("\t" + inter.getName());
        }
        System.out.println("\r\nmethods of proxy class are: ");
        for (Method method : operate.getClass().getMethods()) {
            System.out.println("\t" + method.getName());
        }

        // save proxy class to root of this project, you can use jd-gui to see content of the saved file
        String saveFileName = "$Proxy0.class";
        ProxyUtils.saveProxyClass(saveFileName, operate.getClass().getSimpleName(), operate.getClass().getInterfaces());
        System.out.println("\r\nContent of " + operate.getClass().getSimpleName() + ".class has saved to file "
                + saveFileName + " at root of this project");
    }
}
