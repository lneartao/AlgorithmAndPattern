package com.general.lneartao.lib.effectivejava.r6;

/**
 * 坚持使用标准的函数接口
 * <p>
 * 标准的函数接口指的是java 8 新增的 java.util.function包里面的40多个接口。
 * 现有的大多数标准函数接口都只支持基本类型，千万不要用带包装类型的基础函数接口来代替基本函数接口
 * 必须始终用@FunctionalInterface注解对自己编写的函数接口进行标注
 * 不要在相同的参数位置，提供不同的函数接口来进行多次重装的方法，否则可能在客户端导致歧义。
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class I44 {
}
