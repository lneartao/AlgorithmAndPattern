package com.general.lneartao.lib.concurrency;

import com.general.lneartao.lib.concurrency.safe.CountingFactorizer;
import com.general.lneartao.lib.concurrency.unsafe.LazyInitRace;
import com.general.lneartao.lib.concurrency.unsafe.UnsafeCachingFactorizer;
import com.general.lneartao.lib.concurrency.safe.SynchronizedFactorizer;

/**
 * 1、Java中主要同步机制是关键字synchronized, 它提供了一种独占的加锁方式来支持原子性，但同步这个术语还包括volatile类型的变量，显示锁以及原子变量
 * 2、线程安全性：当多个线程访问某个类时，这个类始终都能表现出正确的行为，那么就称这个类是线程安全的
 * 3、无状态对象一定是线程安全的，无状态对象：它既不包含任何域，也不包含任何对其他类中域的引用
 * 4、竞态条件：由于不恰当的执行时序而出现不正确的结果是一种非常重要的情况
 * a.先检查后执行操作：通过一个可能失效的观测结果来决定下一步的动作，常见情况是延迟初始化 {@link LazyInitRace}
 * <p>
 * 5、原子操作：对于访问同一个状态的所有操作（包括该操作本身）来说，这个操作是一个以原子方式执行的操作
 * {@link CountingFactorizer} {@link UnsafeCachingFactorizer}
 * 6、同步代码块：一个作为锁的对象引用，一个作为由这个锁保护的代码块。以synchronized来修饰的方法就是一种横跨整个方法体的同步代码块，
 * 其中该同步代码块的锁就是方法调用所在的对象。静态的synchronized方法以Class对象作为锁
 * 7、每个Java对象都可以用做一个实现同步的锁，这些锁成为内置锁(Intrinsic Lock)或监视器锁(Monitor Lock)。线程在进入同步代码块之前会自动获得锁，
 * 并且在退出同步代码块时自动释放锁，而无论是通过正常的控制路径退出，还是通过从代码块中抛出异常退出。获得内置锁的唯一途径就是进入由这个锁保护的同步代码块或方法。
 * Java的内置锁相当于一种互斥体（或互斥锁），这意味着最多只有一个线程能持有这种锁。 {@link SynchronizedFactorizer}
 *
 * @author lneartao
 * @date 2018/4/12.
 */
public class Note {
}
