package com.general.lneartao.lib.effectivejava.r2;

/**
 * 覆盖equals时总要覆盖hashCode
 * <p>
 * 通用的约定规范：
 * 1. 只要对象equals方法的比较操作所用到的信息没有被修改，那么对同一个对象的多次调用，hashCode方法都必须始终返回一个值
 * 2. 如果两个对象根据equals方法比较是相等的，那么调用这两个对象中的hashCode方法都必须产生相同的整数结果
 * 3. 如果两个对象的equals方法比较是不相等的，那么调用这两个对象中的hashCode方法不要求产生不同的整数结果，但是如果能产生截然不同的整数结果，可以提高散列表的性能。
 * 注意：
 * 1. 不要试图从散列码计算中排除掉一个对象的关键域来提高性能
 * 2. 不要对hashCode方法的返回值做出具体的规定，因此客户端无法理所当然地依赖它
 * 提升：
 * @see com.google.common.hash.Hashing
 * @see com.google.auto.value.AutoValue
 * 推荐使用AutoValue
 *
 * @author lneartao
 * @date 2020/1/10.
 */
public class I11 {
}
