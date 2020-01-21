package com.general.lneartao.lib.effectivejava.r6;

import java.math.BigInteger;
import java.util.stream.LongStream;

/**
 * 谨慎地使用Stream并行
 * <p>
 * 如果源头是来自Stream.iterate，或者使用了中间操作的limit，那么并行pipeline也不可能提升性能
 * 千万不要任意地并行Stream pipeline，它造成的性能你后果有可能是灾难性的
 * 在Stream上通过并行获得的性能，最好是通过ArrayList、HashMap、HashSet和ConcurrentHashMap实例、数组、int范围和long范围等内存相邻数据。
 * 并行Stream不仅可能降低性能，包括活性失败，还可能导致结果出错，以及难以预计的行为。
 * 在适当的条件下，给Stream Pipeline添加parallel调用，确实可以在多处理器核的情况下实现近乎线性的倍增，比如下面的例子
 *
 * @author lneartao
 * @date 2020/1/21.
 */
public class I48 {

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 3));
        System.out.println(pi(10 * 10 * 10 * 10 * 10 * 10 * 10 * 10));
    }

    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
//                         .parallel()
                         .mapToObj(BigInteger::valueOf)
                         .filter(i -> i.isProbablePrime(50))
                         .count();
    }
}
