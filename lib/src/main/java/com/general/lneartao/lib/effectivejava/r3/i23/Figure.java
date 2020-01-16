package com.general.lneartao.lib.effectivejava.r3.i23;

/**
 * 类层次优于标签类
 * <p>
 * 标签类 {@link FigureUgly} 的缺点：冗长，容易出错，并且效率低下
 * 应该使用子类型化进行修正，如 {@link Circle} {@link Rectangle} 所示
 * 除了纠正了上述的标签类的缺点，还有一个好处，它们可以用来反应类型之间本质上的层次关系，有助于增强灵活性，并有助于更好地进行编译时类型检查。
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public interface Figure {
    double area();
}
