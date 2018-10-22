package com.general.lneartao.lib.refactor.generalization.ExtractSuperclass;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
abstract class Party {
    protected String name;

    Party(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract int getAnnualCost();
}
