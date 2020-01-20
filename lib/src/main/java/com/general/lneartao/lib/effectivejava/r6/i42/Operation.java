package com.general.lneartao.lib.effectivejava.r6.i42;

import java.util.function.DoubleBinaryOperator;

/**
 * Lambda优先于匿名类
 * <p>
 * 带有单个抽象方法的接口作为函数类型，它们的实例称作函数对象，表示函数或者要采取的动作，java 8前创建函数对象的主要方式是通过匿名类。
 * 由于编译器可以利用类型推导，比如给出的泛型信息，推导出需要的类型，所以，可以删除所有Lambda参数的类型，除非它们的存在能够使程序变得更加清晰。
 * Lambda没有名称和文档，如果一个计算本身不是自描述的，或者超出了几行，那就不要把它放在一个Lambda中。
 * 尽可能不要序列化一个Lambda或匿名类实例，因为你无法可靠地通过实现在序列化和反序列化的属性。
 * 千万不要给函数对象使用你们类，除非必须创建非函数接口的类型的实例。
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
