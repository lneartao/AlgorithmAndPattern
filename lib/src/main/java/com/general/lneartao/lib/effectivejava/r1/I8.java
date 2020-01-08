package com.general.lneartao.lib.effectivejava.r1;

/**
 * 避免使用终结方法和清除方法
 * 原因：
 * 1. 不可预测，不知道什么时候运行，不知道会不会运行
 * 2. 有严重的性能损失
 * 3. 有验证的安全问题，为终结方法攻击打开了类的大门
 * 替代方案：
 * 让类实现AutoCloseable，并要求客户在每个实例不再需要的时候调用close方法，一般是利用try-with-resources确保终止，即使遇到异常也是如此。
 *
 * @author lneartao
 * @date 2020/1/8.
 */
public class I8 {
}
