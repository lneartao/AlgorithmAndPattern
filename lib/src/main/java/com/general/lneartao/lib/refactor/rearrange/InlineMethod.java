package com.general.lneartao.lib.refactor.rearrange;

/**
 * 内联函数：在函数调用点插入函数本体，然后移除该函数
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class InlineMethod {

    int numberOfLateDeliveries;

    boolean moreThanFiveLateDeliveries() {
        return numberOfLateDeliveries > 5;
    }

    int getRatingUgly() {
        return (moreThanFiveLateDeliveries()) ? 2 : 1;
    }

    int getRating() {
        return (numberOfLateDeliveries > 5) ? 2 : 1;
    }
}
