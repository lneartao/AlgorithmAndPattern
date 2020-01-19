package com.general.lneartao.lib.effectivejava.r5.i38;

/**
 * 用接口模拟可扩展的枚举
 * <p>
 * 虽然无法编写可扩展的枚举类型，却可以通过编写接口以及实现该接口的基础枚举类型来对它进行模拟。
 * {@link ExtendedOperation}
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public interface Operation {
    double apply(double x, double y);
}
