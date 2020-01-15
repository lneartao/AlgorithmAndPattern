package com.general.lneartao.lib.effectivejava.r3;

/**
 * 接口只用于定义类型
 * <p>
 * 当类实现接口时，接口就充当可以引用这个类的实例的类型，为了其他目的而定义接口是不恰当的。
 * 最反面的例子是接常量接口模式，比如 {@link java.io.ObjectStreamConstants}
 * <p>
 * 如果要导出常量，可以有下面几种做法
 * 1. 与现有类或接口紧密相关，应该包含在它们当中，比如 {@link Integer#MAX_VALUE}
 * 2. 枚举类型
 * 3. 工具类
 *
 * @author lneartao
 * @date 2020/1/15.
 */
public class I22 {
}
