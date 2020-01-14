package com.general.lneartao.lib.effectivejava.r3;

/**
 * 要在公有类而非公有域中使用访问方法
 * <p>
 * 简单地说，就是字段不要用public方法，应该提供访问方法
 * 优势：
 * 1. 可以随时改变它的数据表示法
 * 2. 可以强加约束条件
 * 3. 可以采取一些辅助行为
 * 注意：
 * 1. 如果类是包级私有的，或者是私有的嵌套类，直接暴露它的数据域并没有本质的错误。
 * <p>
 * Java类库中违反了“公有类不应该直接暴露数据域”的例子 {@link java.awt.Point} {@link java.awt.Dimension}
 *
 * @author lneartao
 * @date 2020/1/14.
 */
public class I16 {
}
