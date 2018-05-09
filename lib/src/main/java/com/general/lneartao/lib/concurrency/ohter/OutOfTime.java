package com.general.lneartao.lib.concurrency.ohter;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * 多线程并行处理定时任务时，Timer运行多个TimerTask时，只要其中之一没有捕获抛出的异常，其他任务就会自动终止运行，
 * 而ScheduledExecutorService则没有这个问题
 * 不要这么做，
 *
 * @author lneartao
 * @date 2018/4/30.
 */
public class OutOfTime {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new ThrowTask(), 1);
        TimeUnit.SECONDS.sleep(1);
        timer.schedule(new ThrowTask(), 5);
        TimeUnit.SECONDS.sleep(5);
    }

    static class ThrowTask extends TimerTask {

        @Override
        public void run() {
            throw new RuntimeException();
        }
    }
}
