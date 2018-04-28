package com.general.lneartao.lib.concurrency;

import com.general.lneartao.lib.concurrency.safe.CountingFactorizer;
import com.general.lneartao.lib.concurrency.safe.SynchronizedFactorizer;
import com.general.lneartao.lib.concurrency.unsafe.LazyInitRace;
import com.general.lneartao.lib.concurrency.unsafe.UnsafeCachingFactorizer;

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
 * 8、对于可能被多个线程同时访问的可变状态变量，在访问它时都需要持有同一个锁，在这种情况下，我们称状态变量是由这个锁保护的
 * 9、一种常见的加锁约定：将所有的可变状态都封装在对象内部，并通过对象的内置锁对所有访问可变状态的代码路径进行同步，使得在该对象上不会发生并发访问
 * 10、虽然synchronized方法可以确保单个操作的原子性，但如果要把多个操作合并为一个复合操作，还是需要额外的加锁机制，如 if(!vector.contains(element)) vector.add(element);
 * 11、内存可见性：确保当一个线程修改了对象状态后，其他线程能够看到发生的状态变化
 * 12、重排序：线程中的操作无法按照程序中指定的顺序来执行 {@link com.general.lneartao.lib.concurrency.unsafe.NoVisibility}
 * 13、最低安全性：当线程在没有同步的情况下读取变量时，可能会得到一个失效值，但至少这个值是由之前某个线程设置的值，而不是一个随机值。
 * 例外：非volatile类型的64位数值变量(double, long)，JVM运行将64位的读写分解为两个32位的操作，除非用关键字volatile声明或加锁保护
 * 14、加锁的含义不仅仅局限于互斥行为，还包括内存可见性，为了确保所有线程都能看到共享变量的最新值，所有执行读写操作的线程都必须在同一个锁上同步
 * 15、volatile变量提供了变量的可见性而不保证原子性，谨慎或少用volatile。典型用法：检查某个状态标记以判断是否退出循环
 * 16、发布(Publish)一个对象，使对象能够在当前作用域之外的代码使用；当某个不应该发布的对象被发布时，这就叫逸出(Escape)。
 * {@link com.general.lneartao.lib.concurrency.unsafe.UnsafeStates} {@link com.general.lneartao.lib.concurrency.unsafe.ThisEscape}
 * 17、线程封闭：在单线程内访问数据，它是实现线程安全的最简单的方式之一
 * a、Ad-hoc线程封闭：维护线程封闭性的职责完全由程序实现来承担，因此这是非常脆弱的。（尽量避免使用）
 * b、栈封闭：只能通过局部变量才能访问对象。（方法）
 * c、ThreadLocal类：这个类能使线程中的某个值与保存值的对象关联起来。它提供了get和set方法，为每个使用该变量的线程都存有一份独立的副本，
 * 它通常用于防止对可变的单实例变量或全局变量进行共享。
 * 18：不可变对象一定线程安全的。必须满足的条件：对象创建后其状态就不能修改；对象的所有域都是final类型，
 * 对象是正确创建的（this没有逸出，看第15条），（要和volatile结合使用？）
 * {@link com.general.lneartao.lib.concurrency.immutable.ThreeStooges}
 * {@link com.general.lneartao.lib.concurrency.safe.VolatileCachedFactorizer}
 * 19、final域能确保初始化过程的安全性，从而可以不受限制地访问不可变对象，并在共享这些对象时无须同步。
 * 20、安全地发布一个对象：在静态初始化函数中初始化一个对象的引用；将对象的引用保存到volatile类型的域或AtomicReference对象中；
 * 将对象的引用保存到某个正确构造对象的final类型域中；将对象的引用保存到一个由锁保护的域中
 * 21、在并发程序中使用和共享对象时，可以使用一些实用的策略：线程封闭；只读共享；线程安全共享；保护对象（必须通过持有特定的锁来访问）
 * 22、设计线程安全的类：找出构成对象状态的所有变量；找出约束状态变量的不变性条件；建立对象状态的并发访问管理策略
 * 23、先验条件（如验空）~后验条件（如7自加后是8）
 * 24、状态变量的所有者将决定采用何种加锁协议来维持变量状态的完整性。所有权意味着控制权。然而，如果发布了某个可变对象的引用，那么就不再拥有独占的控制权
 * 25、将数据封装在对象内部，可以将数据的访问限制在对象的方法上，从而更容易确保线程在访问数据时总能持有正确的锁
 * {@link com.general.lneartao.lib.concurrency.safe.PersonSet}
 * 26、线程安全性的委托 {@link com.general.lneartao.lib.concurrency.safe.DelegatingVehicleTracker}
 * {@link com.general.lneartao.lib.concurrency.safe.VisualComponent}
 * {@link com.general.lneartao.lib.concurrency.unsafe.NumberRange}
 * 27、如果一个状态变量是线程安全的，并且没有任何不变性条件来约束它的值，在变量的操作上也不存在任何不允许的状态转换，那么就可以安全地发布这个变量
 * {@link com.general.lneartao.lib.concurrency.safe.PublishVehicleTracker}
 * 28、客户端加锁机制：要明确线程同步加锁中加的锁是哪个锁，否则有可能无法实现同步
 * {@link com.general.lneartao.lib.concurrency.safe.GoodListHelper}
 * 29、使用组合为现有的类添加一个原子操作{@link com.general.lneartao.lib.concurrency.safe.ImprovedList}
 * 30、同步容器类虽然是线程安全的，但在某些情况下可能需要额外的客户端加锁来保护复合操作，如迭代、跳转以及条件运算（需要获得同步容器对象锁进行加锁）
 * 31、必须对所有共享容器迭代的地方加锁(也可以复制容器进行迭代)；隐藏迭代器 {@link com.general.lneartao.lib.concurrency.unsafe.HiddenIterator}
 * 32、同步容器类（Collections类中的synchronized各种）和并发容器类（java.util.concurrent包中的类）的区别~ 同步容器将所有对容器状态的访问都串行化，以实现它们的线程安全性，
 * 但是这种代价是严重降低并发性，当多个线程竞争容器的锁时，吞吐量将严重降低。因此，最好用并发容器来替代同步容器，可以极大地提高伸缩性并降低风险
 * 33、ConcurrentHashMap不能被加锁来执行独占访问，因此我们无法使用客户端加锁来创建新的原子操作（别的并发容器也一样？，并发容器不适用于扩展功能？）。
 * 使用的是分段锁机制，缺陷是size和isEmpty的语义被弱化了以反映容器的并发特性，所以它们返回的结果在计算时可能已经过期了。
 * 34、CopyOnWriteArrayList的安全保证在于每次修改时，都会创建并重新发布一个新的容器副本，该容器的迭代器保留一个指向底层基础数组的引用。（缺点：每次修改都会复制底层数组）
 * 35、阻塞方法和中断方法，当Thread抛出InterruptedException时的处理方法：1、传递给方法的调用者，恢复中断
 * 36、同步工具类：
 * 闭锁 CountDownLatch {@link com.general.lneartao.lib.concurrency.ohter.TestHarness}
 * FutureTask {@link com.general.lneartao.lib.concurrency.ohter.Preloader}
 * 信号量（可用于实现资源池）{@link com.general.lneartao.lib.concurrency.ohter.BoundedHashSet}
 * 栅栏 {@link com.general.lneartao.lib.concurrency.ohter.CellularAutomata}
 * <p>
 * p94
 *
 * @author lneartao
 * @date 2018/4/12.
 */
public class Note {
}
