package com.general.lneartao.lib.designpattern.templatemethod;

/**
 * Created by lneartao on 2017/11/24.
 */

public class HalflingThief {
    private StealingMethod mMethod;

    public HalflingThief(StealingMethod method) {
        mMethod = method;
    }

    public void steal() {
        mMethod.steal();
    }

    public void changeMethod(StealingMethod method) {
        mMethod = method;
    }
}
