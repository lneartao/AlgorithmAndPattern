package com.general.lneartao.lib.puzzlers.p83;

/**
 * Dog扩展了Exception，而Exception实现了Serializable，意味着Dog是可序列化的，
 * 而解序列化会创建一个隐藏的构造器，这就是CopyDog.class所做的事情
 * 修正的方法：添加readResolve(), 将那个隐藏的构造器转变成一个隐藏的静态工厂，以返回原来那个Dog
 * 教训：实现了Serializable的单例类，必须有一个readResolve()，用以返回它的唯一实例
 *
 * @author lneartao
 * @date 2018/4/10.
 * @see CopyDog
 */
public class Dog extends Exception {
    public static final Dog INSTANCE = new Dog();

    private Dog() {
    }

    @Override
    public String toString() {
        return "Woof";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
