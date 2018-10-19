package com.general.lneartao.lib.refactor.simplify_method;

/**
 * 令函数携带参数：建立单一函数，以参数表达那些不同的值
 * @author lneartao
 * @date 2018/10/17.
 */
public class ParameterizeMethod {

    private Dollars baseCharge() {
        double result = usageInRange(0, 100) * 0.03;
        result += usageInRange(100, 200) * 0.05;
        result += usageInRange(200, Integer.MAX_VALUE) * 0.07;
        return new Dollars(result);
    }

    private int usageInRange(int start, int end) {
        if (lastUsage() > start) {
            return Math.min(lastUsage(), end) - start;
        } else {
            return 0;
        }
    }

    private int lastUsage() {
        return 0;
    }

    class Dollars {

        public Dollars(double result) {

        }
    }
}
