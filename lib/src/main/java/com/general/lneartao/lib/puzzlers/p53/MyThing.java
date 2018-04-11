package com.general.lneartao.lib.puzzlers.p53;

/**
 * 这个解决方案使用了交替构造器调用机制，这个机制允许一个类中的某个构造器链接调用同一个类中的另一个构造器
 * 这里所展示的私有构造器捕获惯用法是一种非常有用的模式
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class MyThing extends Thing {

    private final int arg;

    public MyThing() {
        this(SomeOtherClass.func());
    }

    public MyThing(int i) {
        super(i);
        arg = i;
    }
}
