package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 如果初始化一个域的时间和空间代价比较低，或者该域在程序的每一次执行中都需要用到时，那么使用积极初始化是恰当的。
 * 如果其代价比较高，或者该域在某些执行中并不会被用到，那么懒性初始化可能是更好的选择。
 * 另外，懒性初始化对于打破类或实例初始化中的循环也可能是必须的。
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P52 {
    public static void main(String[] args) {
        Logger.printl(Cache.getSum());
    }
}

/**
 * initialized的位置影响了结果
 * 因为静态变量和静态语句块的初始化顺序是受代码顺序影响的
 */
class Cache {

//    private static boolean initialized = false;

    static {
        initializeIfNecessary();
    }

    private static int sum;

    public static int getSum() {
        initializeIfNecessary();
        return sum;
    }

    private static boolean initialized = false;

    private static void initializeIfNecessary() {
        if (!initialized) {
            for (int i = 0; i < 100; i++) {
                sum += i;
            }
            initialized = true;
        }
    }
}

class ModifiedCache {
    private static final int sum = computeSum();

    private static int computeSum() {
        int res = 0;
        for (int i = 0; i < 100; i++) {
            res += i;
        }
        return res;
    }

    public static int getSum() {
        return sum;
    }

}
