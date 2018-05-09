package com.general.lneartao.lib.concurrency;

import com.general.lneartao.lib.concurrency.ohter.DynamicOrderDeadlock;
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
 * 37、在线程中执行任务
 * {@link com.general.lneartao.lib.concurrency.ohter.SingleThreadWebServer}
 * {@link com.general.lneartao.lib.concurrency.ohter.ThreadPerTaskWebServer}
 * 38、Executor 的四个生命周期：创建、提交、开始和完成。已提交但尚未开始的任务可以取消，但那些已经开始执行的任务，只有当它们响应中断时，才能取消
 * {@link com.general.lneartao.lib.concurrency.ohter.TaskExecutionWebServer}
 * {@link com.general.lneartao.lib.concurrency.ohter.LifecycleWebServer}
 * 39、Runnable是一种有很大局限的抽象，虽然run能写入到日志文件或将结果放入某个共享的数据结构，但它不能返回一个值或抛出一个受检查的异常。
 * 所以可以用Callable，一种更好的抽象，还有Future，他表示了一个任务的生命周期，并提供了相应的方法。
 * {@link com.general.lneartao.lib.concurrency.ohter.SingleThreadRenderer}
 * {@link com.general.lneartao.lib.concurrency.ohter.FutureRenderer}
 * {@link com.general.lneartao.lib.concurrency.ohter.Renderer}
 * 40、Java没有提供任何机制来安全地终止线程，（包括stop(), suspend()），但它提供了中断(interruption)
 * 41、任务取消：外部代码能在某个操作正常完成之前将其置入“完成”状态。一种协作机制是设置某个“已请求取消”标志位，并定期查看。
 * {@link com.general.lneartao.lib.concurrency.ohter.BrokenPrimeProducer}
 * {@link com.general.lneartao.lib.concurrency.safe.PrimeGenerator}
 * 42、调用interrupt并不意味着立即停止目标线程正在进行的工作，而只是传递了请求中断的消息，然后由线程在下一个合适的时刻中断自己。
 * {@link com.general.lneartao.lib.concurrency.ohter.PrimeProducer}
 * 43、由于每个线程拥有各自的中断策略，因此除非你知道中断对该线程的含义，否则就不应该中断这个线程。
 * 44、响应中断：传递异常，从而使你的方法也成为可中断的阻塞方法；恢复中断状态，让调用栈的上层代码能对其处理。
 * 45、当Future.get()抛出InterruptedException或TimeoutException时，如果你知道不再需要结果，那么就可以调用Future.cancel来取消任务
 * 46、处理不可中断的阻塞，如java.io包中的Socket I/O，和同步I/O，Selector的异步I/O。
 * {@link com.general.lneartao.lib.concurrency.ohter.ReaderThread}
 * {@link com.general.lneartao.lib.concurrency.ohter.SocketUsingTask}
 * 47、对于持有线程的服务，只要服务的存在时间大于创建线程的方法的存在时间，那么就应该提供生命周期方法
 * {@link com.general.lneartao.lib.concurrency.ohter.LogWriter}
 * {@link com.general.lneartao.lib.concurrency.ohter.LogService}
 * 48、毒丸对象：指一个放在队列上的对象，当得到这个对象时，立即停止！（用于生产者和消费者的数量都已知的情况下）
 * {@link com.general.lneartao.lib.concurrency.ohter.IndexingService}
 * 49、JVM关闭：正常和强行关闭。关闭钩子是指通过Runtime.addShutdownHook()注册的但尚未开始的线程，这些线程是并发的。
 * 如果是强行关闭，不会运行关闭钩子。关闭钩子应该是线程安全的，在访问共享数据时必须使用同步机制，并且小心地避免死锁。可用于实现服务的清理工作。
 * {@link com.general.lneartao.lib.concurrency.ohter.LogService}
 * 50、守护线程和普通线程，在JVM启动时创建的所有线程中，除了主线程，其他都是守护线程，当创建一个新线程时，新线程将继承创建它的线程的守护状态。
 * 51、任务与执行策略之间的隐形耦合：依赖性任务、使用线程封闭机制的任务、对响应时间敏感的任务、使用ThreadLocal的任务
 * 52、线程饥饿死锁：所有正在执行任务的线程都由于等待其他仍处于工作队列中的任务而阻塞。
 * 每当提交一个有依赖性的Executor任务时，要清楚地知道可能会出现线程“饥饿”死锁，因此需要在代码或配置Executor的配置文件中记录线程池大小或配置限制
 * {@link com.general.lneartao.lib.concurrency.ohter.ThreadDeadlock}
 * 53、基本的任务排队方法有三种：无界队列、有界队列和同步移交。有界队列满了以后，饱和策略开始发挥作用
 * 54、饱和策略：AbortPolicy（抛出未检查的RejectedExecutionException）, CallerRunPolicy（不抛弃任务，也不抛出异常，而是将任务回退给调用者）,
 * DiscardPolicy（悄悄抛弃任务）和DiscardOldestPolicy。
 * 55、扩展ThreadPoolExecutor，有beforeExecute()（抛出一个RuntimeException，后续都不执行）,
 * afterExecute()（除非任务完成后有Error，否则都会执行）, terminated()
 * {@link com.general.lneartao.lib.concurrency.ohter.TimingThreadPool}
 * 56、死锁：哲学家问题
 * 锁顺序死锁：两个线程试图以不同顺序来获得相同的锁。所有线程应该以固定的顺序来获得锁，那么就能避免出现锁顺序死锁问题
 * {@link com.general.lneartao.lib.concurrency.ohter.LeftRightDeadlock}
 * 动态的锁顺序死锁：
 * {@link DynamicOrderDeadlock}
 * 在协作对象之间发生的死锁：如果在持有锁时调用某个外部方法，那么将出现活跃性问题。在这个外部方法中可能会获取其他锁（这可能会产生死锁）
 * 或者阻塞时间过长，导致其他线程无法及时获得当前被持有的锁。
 * {@link com.general.lneartao.lib.concurrency.ohter.car.TaxiLocked}
 * 开放调用：在调用某个方法时不需要持有锁。
 * {@link com.general.lneartao.lib.concurrency.ohter.car.Taxi}
 * 资源死锁：多个线程互相持有彼此正在等待的锁而又不释放自己已持有的锁时会发生死锁。
 * 57、死锁的避免和诊断
 * 支持定时的锁：tryLock()替代内置锁，即通过this进行锁定
 * 通过线程转存信息来分析死锁(Thread Dump)
 * 58、其他活跃性危险
 * 饥饿：当线程由于无法访问它所需要的资源而不能继续执行时，就发生了饥饿。(Starvation)
 * 糟糕的响应性
 * 活锁：不会阻塞，但也不能继续执行，因为线程将不断重复执行相同的操作，而且总会失败。
 * 59、可伸缩性：当增加计算资源（CPU、内存、存储容量或I/O带宽），程序的吞吐量或者处理能力能相应地增加
 * 60、Amdahl定律：在增加计算资源的情况下，程序在理论上能够实现最高加速比，这个值取决于程序中可并行组件与串行组件所占的比重。
 * Speedup <= 1/(F+(1-F)/N)；F是必须被串行执行的部分，N是N个处理器
 * 61、在所有并发程序中都包含一些串行部分，如果你认为你的程序中不存在串行部分，那么可以再仔细检查一遍。
 * {@link com.general.lneartao.lib.concurrency.ohter.WorkerThread}
 * 62、线程引入的开销：
 * 上下文切换
 * 内存同步
 * 阻塞，（自旋等待：指通过循环不断地尝试获取锁，直到成功）
 * 63、在并发程序中，对可伸缩性的最主要威胁就是独占方式的资源锁
 * 64、三种方法降低锁的竞争程度：
 * 减少锁的持有时间
 * 降低锁的请求频率
 * 使用带有协调机制的独占，这些机制允许更高的并发性
 * 65、缩小锁的范围（快进快出）
 * {@link com.general.lneartao.lib.concurrency.safe.AttributeStore}
 * {@link com.general.lneartao.lib.concurrency.safe.BetterAttributeStore}
 * 66、减小锁的粒度，通过锁分解和锁分段等技术实现
 * {@link com.general.lneartao.lib.concurrency.safe.ServerStatusBeforeSplit}
 * {@link com.general.lneartao.lib.concurrency.safe.ServerStatusAfterSplit}
 * {@link com.general.lneartao.lib.concurrency.safe.StripedMap}
 * 67、避免热点域：参看ConcurrentHashMap的size()方法中的分段独立计数
 * 68、ReadWriteLock实现了一种在多个读取操作以及单个写入操作情况下的加锁规则：如果多个读取操作都不会修改共享资源，
 * 那么这些读取操作可以同时访问该共享资源，但在执行写入操作时必须以独占方式来获取锁。
 * 69、并发测试将大致分为安全性测试和活跃性测试。
 * {@link com.general.lneartao.lib.concurrency.test.SemaphoreBoundedBuffer}
 * 70、ReentrantLock实现了Lock接口，并提供了和synchronized相同的互斥性和内存可见性，还提供了可重入的加锁语义。
 * 71、Lock或ReentrantLock都必须在Finally块中释放锁，否则当抛出异常后，那么这个锁将永远无法释放。
 * 72、轮询锁和定时锁：lock.tryLock()
 * 73、ReentrantLock提供了两种公平性选择：非公平的锁（默认）或公平的锁。在公平的锁上，线程将按照它们发出请求的顺序来获得锁，但在非公平的锁上，
 * 则“允许”插队，当一个线程请求非公平的锁时，如果在发出请求的同时该锁的状态变为可用，那么这个线程将跳过队列中所有等待的线程并获得该锁。
 * 74、ReentrantLock在加锁和内存上提供的语义和内置锁相同，此外它还提供了一些其他功能，包括定时的锁、可中断的锁等待、公平性、和实现非块结构的加锁。
 * 然而，在未来JVM可能优化的是内置锁，而不是ReentrantLock，尽量能用内置锁就用它。
 * 75、ReadWriteLock的加锁策略：允许多个读操作同时进行，但每次只允许一个写操作。ReentrantReadWriteLock提供了可重入的加锁语义。
 * {@link com.general.lneartao.lib.concurrency.ohter.ReadWriteMap}
 * 76、状态依赖性的管理
 * {@link com.general.lneartao.lib.concurrency.test.GrumpyBoundedBuffer}
 * {@link com.general.lneartao.lib.concurrency.test.SleepyBoundedBuffer}
 * {@link com.general.lneartao.lib.concurrency.test.BoundedBuffer}
 * 77、使用条件队列（最好避免，尽量基于LinkedBlockingQueue, Latch, Semaphore, FutureTask来构造程序）
 * 条件谓语：使某个操作成为状态依赖操作的前提条件。条件等待中存在一种重要的三元关系，包括加锁、wait方法和一个条件谓语。
 * Object可以是内置的条件队列和锁，wait()、notifyAll()
 * 每当在等待一个条件时，一定要确保在条件谓语变为真时通过某种方式发出通知
 * {@link com.general.lneartao.lib.concurrency.test.BoundedBuffer}
 * 入口协议和出口协议：入口协议就是该操作的条件谓语，出口协议则包括，检查被该操作修改的所有状态变量。并确认它们是否使某个其他的条件谓词变为真，如果是，则通知相关的条件队列。
 * 显式的Condition对象（条件队列）。需要注意的是，它继承了Object，但是和wait(), notify(), notifyAll()对应的方法是await(), signal(), signalAll()，
 * 且提供了更丰富的功能：在每个锁上可存在多个等待、条件等待可以是中断的或不可中断的、基于时限的等待，以及公平的或非公平的队列操作
 * {@link com.general.lneartao.lib.concurrency.test.ConditionBoundedBuffer}
 * 78、AbstractQueuedSynchronizer是一个用于构建锁和同步器的框架，如ReentrantLock, Semaphore, CountDownLatch等等
 * {@link com.general.lneartao.lib.concurrency.safe.OneShotLatch}
 * 79、Java内存模型说明了某个线程的内存操作在哪些情况下对其他线程是可见的。
 * 80、缓存一致性(Cache Coherence)
 * 81、JMM(Java内存模型)为程序中所有的操作定义了一个偏序关系，称之为Happens-Before，它的规则包括
 * 程序顺序规则：如果程序中操作A在操作B之前，那么在线程中A操作将在B操作之前执行；
 * 监视器规则：在监视器锁上的解锁操作必须在同一个监视器锁上的加锁操作之前执行；
 * volatile变量规则：对volatile变量的写入操作必须在该变量的读操作之前执行
 * 线程启动规则：在线程上对Thread.start的调用必须在该变量的读操作之前执行
 * 线程结束规则：线程中的任何操作都必须在其他线程检测到该线程已经结束之前执行，或者从Thread.join中成功返回，或者在调用Thread.isAlive时返回false
 * 中断规则：当一个线程在另一个线程上调用interrupt时，必须在被中断线程检测到interrupt调用之前执行（通过抛出InterruptedException，或者调用isInterrupted和interrupted）
 * 终接器规则：对象的构造函数必须在启动该对象的终接器之前执行完成
 * 传递性：如果操作A在操作B之前执行，并且操作B在操作C之前执行，那么操作A必须在操作C之前执行
 * 81、除了不可变对象外，使用被另一个线程初始化的对象通常都是不安全的，除非对象的发布操作是在使用该对象的线程开始使用之前执行。
 * {@link com.general.lneartao.lib.concurrency.unsafe.UnsafeLazyInitialization}
 * {@link com.general.lneartao.lib.concurrency.safe.SafeLazyInitialization}
 * 82、初始化安全性只能保证通过final域可达的值从构造过程完成时开始的可见性。对于通过非final域可达的值，或者在构成过程完成后可能改变的值，必须采用同步来确保可见性。
 *
 * @author lneartao
 * @date 2018/4/12.
 */
public class Note {
}
