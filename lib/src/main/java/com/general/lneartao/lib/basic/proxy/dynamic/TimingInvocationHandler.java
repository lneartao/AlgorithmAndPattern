package com.general.lneartao.lib.basic.proxy.dynamic;

import com.general.lneartao.lib.Logger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lneartao
 * @date 2018/5/31.
 */
public class TimingInvocationHandler implements InvocationHandler {
    private Object mObject;

    public TimingInvocationHandler() {
    }

    public TimingInvocationHandler(Object object) {
        mObject = object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object obj = method.invoke(mObject, args);
        Logger.printl(method.getName() + " cost time is: " + (System.currentTimeMillis() - start));
        return obj;
    }
}
