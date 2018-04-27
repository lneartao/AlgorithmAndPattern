package com.general.lneartao.lib.concurrency.safe;

import com.general.lneartao.lib.concurrency.annotation.GuardedBy;
import com.general.lneartao.lib.concurrency.annotation.ThreadSafe;

import java.util.HashSet;
import java.util.Set;

/**
 * Using confinement to ensure thread safety
 * 通过封闭机制让不安全的类确保线程安全的访问，最好还是把Person类变成一个线程安全的类（因为这里没有把Person逸出，所有还是安全的）
 * （感觉可以通过封装的这种方式来把所有不安全的类转换成线程安全）
 *
 * @author lneartao
 * @date 2018/4/24.
 */
@ThreadSafe
public class PersonSet {

    @GuardedBy("this")
    private final Set<Person> mPersonSet = new HashSet<>();

    public synchronized void addPerson(Person person) {
        mPersonSet.add(person);
    }

    public synchronized boolean contains(Person person) {
        return mPersonSet.contains(person);
    }

    interface Person {

    }
}
