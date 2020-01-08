package com.general.lneartao.lib.effectivejava.r1;

import java.nio.file.Path;
import java.time.Instant;
import java.util.Enumeration;
import java.util.Random;

/**
 * 用静态工厂方法替代构造器
 * 优点：
 * 1. 有名称 {@link java.math.BigInteger#probablePrime(int, Random)}
 * 2. 不必在每次调用他们的时候都创造一个新对象 {@link Boolean#valueOf(boolean)}
 * 3. 它可以返回原返回类型的子类型对象，比如原返回类型是A, 我可以返回B，因为B继承A
 * 4. 所返回的对象的类可以随着每次调用而发生变化，这取决于静态工厂方法的参数值 {@link java.util.EnumSet#allOf(Class)}
 * 5. 方法返回的对象所属的类，在编写包含该静态工厂方法的类时可以不存在 {@link java.util.ServiceLoader}
 * <p>
 * 缺点：
 * 1. 类如果不含公有的或受保护的构造器，就不能被子类化（通俗的话就是不能继承）
 * 2. 程序员很难发现它们
 * <p>
 * 通常的惯用名词：
 * 1. from：类型转换方法 {@link java.util.Date#from(Instant)}
 * 2. of：聚合方法 {@link java.util.EnumSet#of(Enum, Enum, Enum)}
 * 3. valueOf {@link java.math.BigInteger#valueOf(long)}
 * 4. getInstance：一般返回的是全局单一实例
 * 5. newInstance：能够确保每次调用都返回一个实例 {@link java.lang.reflect.Array#newInstance(Class, int)}
 * 6. getType：像getInstance一样，但工厂方法处于不同的类中的时候使用 {@link java.nio.file.Files#getFileStore(Path)}
 * 7. newType: 像newInstance一样 {@link java.nio.file.Files#newBufferedReader(Path)}
 * 8. type: getType和newType的简版 {@link java.util.Collections#list(Enumeration)}
 *
 * @author lneartao
 * @date 2020/1/3.
 */
public class I1 {

}
