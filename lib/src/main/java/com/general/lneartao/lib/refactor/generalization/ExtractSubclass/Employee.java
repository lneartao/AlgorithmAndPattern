package com.general.lneartao.lib.refactor.generalization.ExtractSubclass;

/**
 * 提炼子类：新建一个子类，将上面所说的那一部分特性移到子类中
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee {

    private int rate;

    public Employee(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
