package com.general.lneartao.lib.refactor.generalization.ReplaceInheritanceWithDelegation;

import java.util.Vector;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class MyStack<E> extends Vector<E> {

    public void push(E element) {
        insertElementAt(element, 0);
    }

    public E pop() {
        E result = firstElement();
        removeElementAt(0);
        return result;
    }
}
