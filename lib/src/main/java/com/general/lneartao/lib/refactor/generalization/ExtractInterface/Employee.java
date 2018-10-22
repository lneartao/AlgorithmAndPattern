package com.general.lneartao.lib.refactor.generalization.ExtractInterface;

/**
 * 提炼接口：将相同的子集提炼到一个独立接口中
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Employee implements Billable{

    private int rate;

    public Employee(int rate) {
        this.rate = rate;
    }

    @Override
    public int getRate() {
        return rate;
    }

    @Override
    public boolean hasSpecialSkill() {
        return true;
    }
}
