package com.general.lneartao.lib.concurrency.ohter.puzzle;

import java.util.Set;

/**
 * Abstraction for puzzles like the 'sliding blocks puzzle'
 *
 * @author lneartao
 * @date 2018/4/30.
 */
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
