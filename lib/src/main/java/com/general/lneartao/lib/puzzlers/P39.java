package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * System.exit被调用时，虚拟机在关闭前要执行两项清理工作
 * 首先，它执行所有的关闭挂钩操作，这些挂钩已经注册到了Runtime.addShutdownHook上，这对于释放VM之外的资源将很有帮助
 * 然后，执行的第二个清理任务与终结器有关
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P39 {

    public static void main(String[] args) {
        methodOne();
        methodTow();
    }

    /**
     * System.exit方法将停止当前线程和所有其他当场死亡的线程，finally子句的出现并不能给予线程继续去执行的特殊权限
     */
    private static void methodOne() {
        try {
            Logger.printl("Hello world");
            System.exit(0);
        } finally {
            Logger.printl("Goodbye world");
        }
    }

    private static void methodTow() {
        Logger.printl("Hello world");
        Runtime.getRuntime().addShutdownHook(new Thread(() -> Logger.printl("Goodbye world")));
        System.exit(0);
    }
}
