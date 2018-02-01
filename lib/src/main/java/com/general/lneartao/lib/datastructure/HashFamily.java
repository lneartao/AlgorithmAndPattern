package com.general.lneartao.lib.datastructure;

/**
 * Created by lneartao on 2017/11/24.
 */

public interface HashFamily<E> {
    int hash(E e, int which);

    int getNumberOfFunctions();

    void generateNewFunctions();
}
