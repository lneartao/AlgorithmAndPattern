package com.general.lneartao.lib.refactor.reorganize_method;

/**
 * 内联临时变量：将所有对该变量的引用动作，替换为对它赋值的那个表达式自身
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class InlineTemp {
    boolean isGoodPriceUgly(Order order) {
        double basePrice = order.basePrice();
        return basePrice > 10000;
    }

    boolean isGoodPrice(Order order) {
        return order.basePrice() > 10000;
    }
}
