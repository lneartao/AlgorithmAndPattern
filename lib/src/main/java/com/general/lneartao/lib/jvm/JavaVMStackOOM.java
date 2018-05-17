package com.general.lneartao.lib.jvm;

/**
 * 虚拟机栈和本地方法栈OOM测试：创建线程导致内存溢出异常
 *
 * @author lneartao
 * @date 2018/5/14.
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
