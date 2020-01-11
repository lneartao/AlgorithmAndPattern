package com.general.lneartao.lib.effectivejava.r2.i13;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;
import java.util.EmptyStackException;

/**
 * 谨慎地覆盖clone
 * <p>
 * cloneable接口的目的是作为对象的一个mixin接口，表明这个对象允许clone，遗憾的是，它没有成功地达到这个目的。
 * 它的缺陷在于缺少一个clone方法， 而Object的clone方法是受保护的。
 * clone方法的通用约定
 * 1. x.clone() != x
 * 2. x.clone().getClass() == x.getClass()
 * 3. x.clone().equals(x)
 * 注意事项
 * 1. 不可变类永远都不应该提供clone方法，因为它只会激发不必要的clone
 * 2. 对super.clone方法的调用应当包含在一个try-catch块中
 * 3. 像构造器一样，clone方法也不应该在构造的过程中，调用可以覆盖的方法
 * 4. 公有的clone方法应该省略throws声明，这样使用起来更加轻松
 * 5. 如果要编写线程安全的clone方法，那么它的clone方法必须得到严格的同步，比如synchronized
 * <p>
 * clone方法就是另一个构造器，必须确保它不会伤害到原始的对象，并确保正确地创建被克隆对象中的约束条件
 * Java支持协变返回类型，比如Object的clone方法返回的是Object，继承与Object的子类的clone方法可以返回子类的类型。 {@link com.general.lneartao.lib.effectivejava.r1.i2.MyPizza}
 * <p>
 * 对象拷贝的更好办法是提供一个拷贝构造器或拷贝工厂 {@link java.awt.Point#Point(Point)}
 * 这种方法优势：不依赖于某一种很有风险、语言之外的对象创建机制，不要求遵守未制定好文档的规范，不会与final域的正常使用发生冲突，不会抛出不必要的受检异常，不需要进行类型转换，
 * 甚至，可以带一个参数，参数类型是该类所实现的接口，比如{@link java.util.HashSet#HashSet(Collection)}, {@link java.util.TreeSet#TreeSet(Collection)}
 * 例外；复制数组最好使用clone方法
 *
 * @author lneartao
 * @date 2020/1/11.
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object o) {
        ensureCapacity();
        elements[size++] = o;
    }

    public Object pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
