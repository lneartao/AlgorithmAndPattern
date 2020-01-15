package com.general.lneartao.lib.effectivejava.r3;

/**
 * 接口优于抽象类
 * <p>
 * 优点：
 * 1. 现有的类可以很容易被更新，以实现新的接口
 * 2. 接口是定义mixin（混合类型）的理想选择
 * 3. 接口允许构造非层次结构的类型框架，比如可以定义singer和songwriter这两个非层次的接口
 * 4. 通过第18条介绍的包装类模式，接口使得安全地增强类的功能成为可能
 * <p>
 * 通过对接口提供一个抽象的骨架实现类，可以把接口和抽象类的优点提供起来，比如 {@link java.util.AbstractList} {@link java.util.AbstractSet} 等等，这种也被称为模板方法。
 * 对于好的骨架实现类而言，好的文档绝对是非常必要的。
 *
 * @author lneartao
 * @date 2020/1/15.
 */
public class I20 {
}
