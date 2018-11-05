package com.general.lneartao.lib.designpattern.observer.ex2;

/**
 * @author lneartao
 * @date 2018/11/5.
 */
public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
