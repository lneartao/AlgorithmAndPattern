package com.general.lneartao.lib.refactor.generalization.ReplaceInheritanceWithDelegation;

import java.util.Vector;

/**
 * 以委托取代继承：在子类中新建一个字段用以保存超类；调整子类函数，令它改而委托超类；然后去掉两者之间的继承关系
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class MyStack<E> {

    private Vector<E> vector = new Vector<>();

    public void push(E element) {
        vector.insertElementAt(element, 0);
    }

    public E pop() {
        E result = vector.firstElement();
        vector.removeElementAt(0);
        return result;
    }

    public int size() {
        return vector.size();
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }
}
