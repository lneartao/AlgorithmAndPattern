package com.general.lneartao.lib.concurrency.ohter;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lneartao
 * @date 2018/4/27.
 */
public class CellularAutomata {
    private final Board mMainBoard;
    private final Worker[] mWorkers;
    private final CyclicBarrier mBarrier;

    public CellularAutomata(Board board) {
        mMainBoard = board;
        int count = Runtime.getRuntime().availableProcessors();
        mBarrier = new CyclicBarrier(count, mMainBoard::commitNewValues);
        mWorkers = new Worker[count];
        for (int i = 0; i < count; i++) {
            mWorkers[i] = new Worker(mMainBoard.getSubBoard(count, i));
        }
    }

    private class Worker implements Runnable {
        private final Board mBoard;

        public Worker(Board board) {
            mBoard = board;
        }

        @Override
        public void run() {
            while (!mBoard.hasConverged()) {
                for (int x = 0; x < mBoard.getMaxX(); x++) {
                    for (int y = 0; y < mBoard.getMaxY(); y++) {
                        mBoard.setNewValue(x, y, compute(x, y));
                    }
                }
                try {
                    mBarrier.await();
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }

        private int compute(int x, int y) {
            return 0;
        }
    }

    interface Board {
        int getMaxX();

        int getMaxY();

        int getValue(int x, int y);

        int setNewValue(int x, int y, int value);

        void commitNewValues();

        boolean hasConverged();

        void waitForConvergence();

        Board getSubBoard(int numPartitions, int index);

    }
}
