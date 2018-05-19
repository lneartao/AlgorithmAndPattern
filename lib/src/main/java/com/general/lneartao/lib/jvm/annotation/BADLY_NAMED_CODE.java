package com.general.lneartao.lib.jvm.annotation;

/**
 * @author lneartao
 * @date 2018/5/18.
 */
public class BADLY_NAMED_CODE {
    enum colors {
        red, blue, green;
    }

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAME_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }
}
