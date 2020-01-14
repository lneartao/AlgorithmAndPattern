package com.general.lneartao.lib.effectivejava.r3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 使类和成员的可访问性最小化
 * <p>
 * 信息隐藏（封装）：一个模块不需要知道其他模块的内部工作情况，该模块隐藏了其内部数据和其他实现细节。
 * 优点：
 * 1. 有效的解耦
 * 2. 可以并行开发，减轻了维护的负担
 * 3. 提高了软件的可重用性
 * 4. 降低了构建大型系统的风险
 * 实现封装的规则：尽可能地使每个类或者成员不被外界访问。
 * private, default, protected, public
 * 注意：
 * 1. 如果这个类实现了Serializable接口（详见86和87条），这些域就有可能会被泄漏到导出的API中。
 * 2. 如果方法覆盖了超类中的一个方法，子类中的访问级别就不允许低于超类中的访问级别。而且，实现接口的话，都会被声明为public。
 * 3. 包含公有可变域的类通常是线程不安全的。
 * 4. 当公有静态final域指向的是可变对象的引用，这个问题很严重。比如 public static final Thing[] VALUES = { ... };
 * 5. 让类具有公有的静态final数组域，或者返回这种域的访问方法，这是错误的。应该使用下面两种方法修正。
 *
 * @author lneartao
 * @date 2020/1/13.
 */
public class I15 {
    private static final String[] PRIVATE_VALUES = {"1", "2"};

    public static List<String> getPrivateValues() {
        return Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));
    }

    /**
     * 因为这个是数组，可以使用clone的方法
     *
     * @return
     */
    public static String[] getPrivateValues2() {
        return PRIVATE_VALUES.clone();
    }
}
