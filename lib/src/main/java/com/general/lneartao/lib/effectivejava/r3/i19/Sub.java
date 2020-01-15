package com.general.lneartao.lib.effectivejava.r3.i19;

/**
 * 要么设计继承并提供文档说明，要么禁止继承
 * <p>
 * 对于专门为了继承而设计的类
 * 1. 必须有文档说明它可覆盖的方法的自用性，比如 {@link java.util.AbstractCollection#remove(Object)}
 * 2. 必须以精心挑选的受保护的方法的形式，提供适当的钩子，以便进入其内部工作，比如 {@link java.util.AbstractList#removeRange(int, int)}
 * 3. 唯一的测试方法就是编写子类
 * 4. 对于文档中所说明的自用模式，以及对于其受保护方法和域中所隐含的实现策略，你实际上已经做出了永久的承诺
 * 5. 构造器、clone和readObject决不能调用可被覆盖的方法，比如下面的这个类
 * 6. 对于实现了 Cloneable和Serializable接口，可以参考第13和第86条
 *
 * @author lneartao
 * @date 2020/1/15.
 */
public final class Sub extends Super {
    private final Instance instance;

    public Sub() {
        this.instance = Instance.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instance);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }
}
