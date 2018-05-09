package com.general.lneartao.lib.concurrency.ohter.puzzle;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Solver that recognizes when no solution exists
 *
 * @author lneartao
 * @date 2018/4/30.
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {

    public PuzzleSolver(Puzzle<P, M> puzzle) {
        super(puzzle);
    }

    private final AtomicInteger taskCount = new AtomicInteger(0);

    @Override
    protected Runnable newTask(P p, M m, PuzzleNode<P, M> n) {
        return new CountingSolverTask(p, m, n);
    }

    class CountingSolverTask extends SolverTask {
        CountingSolverTask(P pos, M move, PuzzleNode<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        @Override
        public void run() {
            try {
                super.run();
            } finally {
                if (taskCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }
}
