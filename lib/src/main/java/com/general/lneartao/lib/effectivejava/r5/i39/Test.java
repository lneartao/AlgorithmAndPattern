package com.general.lneartao.lib.effectivejava.r5.i39;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解优于命名模式
 * 命名模式的缺点：
 * 1. 有些程序元素需要通过某种工具或者框架进行特殊处理。比如java 4 之前的JUnit测试框架要求test方法打头，否则无法运行，也不会报错。
 * 2. 无法确保它们只用于相应的程序元素上
 * 3. 没有提供将参数值与程序元素关联起来的好办法
 * 而注解很好地解决了所有这些问题
 * <p>
 * 只在抛出特殊异常时才成功的测试 {@link ExceptionTest}
 * 抛出任何一种指定异常时都能通过 {@link Exception2Test}
 * <p>
 * 都应该使用Java平台所提供的预定义的注解类型
 *
 * @author lneartao
 * @date 2020/1/19.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
}
