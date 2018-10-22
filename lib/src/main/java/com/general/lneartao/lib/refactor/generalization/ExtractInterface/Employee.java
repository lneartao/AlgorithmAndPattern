package com.general.lneartao.lib.refactor.generalization.ExtractInterface;

/**
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

    public boolean hasSpecialSkill(){
        return true;
    }
}
