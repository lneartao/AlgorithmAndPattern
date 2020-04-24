package com.general.lneartao.lib.jvm.gc;

/**
 * 验证活跃线程作为GC Root
 *
 * @author lneartao
 * @date 2020/4/1.
 */
public class GCRootThread {
    private static int _10MB = 10 * 1024 * 1024;
    private byte[] memory = new byte[8 * _10MB];

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始");
        printMemory();
        AsyncTask task = new AsyncTask(new GCRootThread());
        Thread thread = new Thread(task);
        thread.start();
        System.gc();
        System.out.println("main方法执行完，完成GC");
        printMemory();

        thread.join();
        // 这里注意一定要置空，否则也无法回收
        task = null;
        System.gc();
        System.out.println("线程代码执行完毕，完成GC");
        printMemory();
    }

    private static class AsyncTask implements Runnable {
        private GCRootThread gcRootThread;

        public AsyncTask(GCRootThread gcRootThread) {
            this.gcRootThread = gcRootThread;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printMemory() {
        System.out.println("free is " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " M");
        System.out.println("total is " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + " M");
    }
}
