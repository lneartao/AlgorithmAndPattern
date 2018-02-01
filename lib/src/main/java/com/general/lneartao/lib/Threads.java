package com.general.lneartao.lib;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.general.lneartao.lib.Logger.printl;

/**
 * Created by lneartao on 2017/11/16.
 */

public class Threads {
    public static void main(String[] args) {
//        serialRun();
//        crossRun();
//        runDAfterABC();
//        runABCWhenAllReady();
//        doTaskWithResultWorker();
        notifyRun();
    }

    public static void normalRun() {
        Thread A = new Thread(() -> printNum("A"));

        Thread B = new Thread(() -> printNum("B"));
        A.start();
        B.start();
    }

    //    让两个线程依次执行
    public static void serialRun() {
        /*Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNum("A");
            }
        });*/

        Thread A = new Thread(() -> printNum("A"));

        Thread B = new Thread(() -> {
            printl("B is waiting for A");
            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printNum("B");
        });
        A.start();
        B.start();
    }

    //    让两个线程按照指定方式有序交叉运行
    public static void crossRun() {
        Object lock = new Object();
        Thread A = new Thread(() -> {
            System.out.println("INFO: A is waiting for lock.");
            synchronized (lock) {
                printl("INFO: A got the lock.");
                printl("A 1");
                try {
                    printl("INFO: A is ready to wait, and gave up the lock.");
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printl("INFO: A has been notified, A got the lock again.");
                printl("A 2");
                printl("A 3");
            }
        });

        A.start();
        Thread B = new Thread(() -> {
            printl("INFO: B is waiting for lock.");
            synchronized (lock) {
                printl("INFO: B got the lock.");
                printNum("B");
                printl("INFO: B completes printing, and invokes notify method.");
                lock.notify();
            }
        });
//        A.start();            // 这个位置调用A,B的话 有可能B比A先开启，就会造成死锁～
        B.start();
    }

    //    这里例子用来说明nofity()只是宣称调用过wait()的线程可以参与获得锁的竞争了，但是不释放锁
    public static void notifyRun() {
        new Thread(() -> {
            synchronized (Threads.class) {
                printl("enter thread1...");
                printl("thread1 is waiting.");
                try {
                    Threads.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printl("thread1 is going on...");
                printl("thread1 is being over!");
            }
        }).start();
        // 加这个是为了避免线程2先启动造成死锁
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            synchronized (Threads.class) {
                printl("enter thread2...");
                printl("thread2 notify other thread can release wait status...");
                Threads.class.notify();
                printl("thread2 is sleeping ten millisecond...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printl("thread2 is going on...");
                printl("thread2 is being over!");
            }
        }).start();
    }

    //    四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
    public static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(() -> {
            printl("D is waiting for other three threads");
            try {
                countDownLatch.await();
                printl("All done, D starts working.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(() -> {
                printl(tN + " is working.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printl(tN + " finished");
                countDownLatch.countDown();
            }).start();
        }
    }

    //    三个运动员各自准备，等到三个人都准备好后，再一起跑
    private static void runABCWhenAllReady() {
        int runner = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(runner);
        final Random random = new Random();
        for (char runnerName = 'A'; runnerName <= 'C'; runnerName++) {
            final String rN = String.valueOf(runnerName);
            new Thread(() -> {
                long prepareTime = random.nextInt(10000) + 100;
                printl(rN + " is preparing for time: " + prepareTime);
                try {
                    Thread.sleep(prepareTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    printl(rN + " is prepared, waiting for others");
                    cyclicBarrier.await();  // 当前线程准备完毕，等待别人准备好
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                printl(rN + " starts running"); // 所有线程准备好了，一起开始
            }).start();
        }
    }

    //    子线程完成某件任务后，把得到的结果回传给主线程
    public static void doTaskWithResultWorker() {
        Callable<Integer> callable = () -> {
            printl("Task starts");
            Thread.sleep(1000);
            int result = 0;
            for (int i = 0; i <= 100; i++) {
                result += i;
            }
            printl("Task finished and return result");
            return result;
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            printl("Before futureTask.get()");
            printl("Result: " + futureTask.get());  // get()方法会阻塞主线程，然后Callable内部开始执行，并返回运算结果
            printl("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void printNum(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            printl(threadName + " print: " + i);
        }

    }
}
