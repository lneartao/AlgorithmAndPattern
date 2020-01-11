package com.general.lneartao.lib.effectivejava.r2;

import java.math.BigInteger;

/**
 * 始终要覆盖toString
 * 优点：提供好的toString实现可以使类用起来更加舒适，使用了这个类的系统也更易于调试
 * 做法：
 * 1. toString方法应该返回对象中包含的所有值得关注的信息
 * 在实现toString的时候，是否指定返回值的格式：
 * 指定了格式： {@link BigInteger#toString()} ，那么他们也会提供一些静态方法或构造器进行转换 {@link BigInteger(String, int)}，缺点是后续的版本只能一直使用这种格式
 * 未指定格式：可以随时改变toString的返回
 * 2. 无论是否决定指定格式，都应该在文档中明确表明你的意图
 * 3. 都为toString返回值中包含的所有信息提供一种可以通过编程访问之的途径
 *
 * @author lneartao
 * @date 2020/1/10.
 */
public class I12 {
}
