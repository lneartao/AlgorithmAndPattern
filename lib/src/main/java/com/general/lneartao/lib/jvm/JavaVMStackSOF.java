package com.general.lneartao.lib.jvm;

import com.general.lneartao.lib.Logger;

/**
 * 虚拟机栈和本地方法栈OOM测试：如果线程请求的栈深度大于虚拟机所允许的最大深度
 *
 * @author lneartao
 * @date 2018/5/14.
 */
public class JavaVMStackSOF {

    private int stackLength = -1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            Logger.printl("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
