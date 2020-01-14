package com.general.lneartao.lib.effectivejava.r3;

import java.math.BigInteger;

/**
 * 使类可变性最小化
 * <p>
 * 核心：除非有很好的理由要让类成为可变的类，否则它应该是不可变的
 * 优点：
 * 1. 不可变对象比较简单
 * 2. 不可变对象本质上是线程安全的，它们不要求同步
 * 3. 不可变对象可以被自由地共享
 * 4. 还可以共享内部信息，比如 {@link BigInteger#negate()}
 * 5. 为其他对象提供大量的构件
 * 6. 无偿地提供了失败的原子性，它们的状态永远不变，不存在临时不一致的可能性。
 * 缺点：
 * 对于每个不同的值都需要一个单独的对象
 * <p>
 * 使类成为不可变类，要遵循下面五条规则：
 * 1. 不要提供任何会修改对象状态的方法（set方法）
 * 2. 保证类不会被扩展，一般声明为final类
 * 3. 声明所有域都是final的
 * 4. 声明所有的域都是私有的
 * 5. 确保对于任何可变组件的互斥访问，就是不要返回可变对象的引用，
 * ps: 如果不可变类实现序列化，那么应该提供readResolve方法
 * pps: 如果类不能做成不可变的，仍然应该尽可能地限制它的可变性
 * <p>
 * 下面的方法虽然不常用，但它通常是实现不可变类最好的替代方法。
 *
 * @author lneartao
 * @date 2020/1/14.
 */
public class I17 {
    private final double re;
    private final double im;

    private I17(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static I17 valueOf(double re, double im) {
        return new I17(re, im);
    }
}
