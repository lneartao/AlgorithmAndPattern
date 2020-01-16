package com.general.lneartao.lib.effectivejava.r3.i24;

/**
 * 静态成员类优于非静态成员类
 * <p>
 * 嵌套类有四种，分别是
 * 1. 静态成员类：定义在一个类内部的普通类，当它被传入外部类时，它可以访问外围类的所有成员，包括那些声明为私有的成员，它是外围类第一个静态成员。
 * 它的常见用法是作为公有的辅助类，和它的外部类一起使用才有意义。 {@link String#CASE_INSENSITIVE_ORDER} {@link com.general.lneartao.lib.effectivejava.r3.i24.Foo.FooInner}
 * 静态成员类相比非静态成员类拥有的三个优势：
 * a. 内嵌类的实例可以独立于外围类的实例而存在。
 * b. 内嵌类和外围类的实例之间没有关联，减少时间和空间的开销。
 * c. 当外围类实例符合垃圾回收时，可以被回收掉。如果使用的是非静态成员类则不行，造成内存泄漏，并且难以发现。（解决方案：换成静态成员类，去掉隐含关联外部类的实例，使用弱引用来引用外部类的实例）
 * 2. 非静态成员类：它的每个实例都隐含地与外围类的一个外围实例相关联。可以调用外围类的属性和方法 {@link com.general.lneartao.lib.effectivejava.r3.i24.Foo.FooInner2}
 * 在没有外部实例的情况下，不可能创建非静态成员类的实例。
 * 3. 匿名类：不是外部类的成员，不可能拥有任何静态成员，而是拥有常数变量，在声明之外无法实例化，不能执行instanceof测试，无法扩展一个类等等，现在可以使用lambda表达式在代替匿名类创建小型函数对象和过程对象。
 * 4. 局部类：用于生命局部变量
 * 2、3、4都称为内部类
 * <p>
 * 静态成员类和非静态成员类的主要区别在于是否含有一个外部实例的引用，前者无，后者有。
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public class I24 {
}