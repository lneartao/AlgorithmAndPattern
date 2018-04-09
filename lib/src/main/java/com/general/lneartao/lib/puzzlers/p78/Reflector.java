package com.general.lneartao.lib.puzzlers.p78;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 原因在于该方法所在类型的访问级别，这个类型所扮演的角色和一个普通方法调用中的限定类型是相同的
 * 这里的类型通过it.getClass()返回的是HashMap.KeyIterator，它恰好是私有的嵌套类。
 * 访问位于其他包中的非公共类型的成员是不合法的，这对于一般的访问还是通过反射的访问都是禁止的
 * 提醒：应该只有在实例化时才使用反射，而方法调用都通过使用接口进行
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class Reflector {
    public static void main(String[] args) throws Exception {
        Set<String> s = new HashSet<>();
        s.add("foo");
        Iterator it = s.iterator();
        Method m = it.getClass().getMethod("hasNext");
        // 修正
//        Method m = Iterator.class.getMethod("hasNext");
        System.out.println(m.invoke(it));
    }
}
