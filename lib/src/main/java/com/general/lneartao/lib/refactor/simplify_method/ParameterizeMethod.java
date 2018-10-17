package com.general.lneartao.lib.refactor.simplify_method;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class ParameterizeMethod {


    private Dollars baseCharge() {
        double result = Math.min(lastUsage(), 100) * 0.03;
        if (lastUsage() > 100) {
            result += (Math.min(lastUsage(), 200) - 100) * 0.05;
        }
        if (lastUsage() > 200) {
            result += (lastUsage() - 200) * 0.07;
        }
        return new Dollars(result);
    }

    private int lastUsage() {
        return 0;
    }

    class Dollars {

        public Dollars(double result) {

        }
    }
}
