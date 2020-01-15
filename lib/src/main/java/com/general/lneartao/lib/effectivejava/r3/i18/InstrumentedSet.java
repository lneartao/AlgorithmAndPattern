package com.general.lneartao.lib.effectivejava.r3.i18;

import java.util.Collection;
import java.util.Set;

/**
 * 复合优先于（子类）继承
 * <p>
 * 本条的讨论不适用于接口继承。
 * 缺点：
 * 1. 继承打破封装性，子类依赖于其超类中特定功能的实现细节。
 * 2. 如果子类和超类处在不同的包中，并且超类并不是为了继承而设计的，那么继承将会导致脆弱性。
 * <p>
 * 下面这个类是复合+转发的实现，{@link ForwardingSet}是转发类，本类是包装类，属于Decorator模式。
 * 注意：包装类不适用于回调框架，在回调框架中，对象把自身的引用传递给其他的对象，用于后续的调用。因为被包装起来的对象并不知道它外面的包装对象，
 * 所以它传递一个指向自身的引用(this)，回调时避开了外面的包装对象，这个被称为SELF问题。
 * google 的 Guava就为所有的集合接口提供了转发类。
 * Java类库中有几个违反了本条原则的地方，比如{@link java.util.Stack} 并不是 {@link java.util.Vector}，所以Stack不应该扩展Vector
 * {@link java.util.Properties} 也不是 {@link java.util.Hashtable} ，它们本应该用复合而不是继承的方式。
 * <p>
 * 最后再使用继承前，问问自己，A到底是不是B。
 *
 * @author lneartao
 * @date 2020/1/14.
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;

    public InstrumentedSet(Set<E> s) {
        super(s);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
