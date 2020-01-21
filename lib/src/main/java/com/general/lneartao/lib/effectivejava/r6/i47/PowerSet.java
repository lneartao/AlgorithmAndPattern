package com.general.lneartao.lib.effectivejava.r6.i47;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Stream要优先用Collection作为返回类型
 * <p>
 * 对于公共的、返回序列的方法，Collection或者适当的子类型通常是最佳的返回类型
 * 千万别在内存中保存巨大的序列，将它作为集合返回即可
 *
 * @author lneartao
 * @date 2020/1/21.
 */
public class PowerSet {

    /**
     * 返回一个指定集合的幂集
     *
     * @param s
     * @param <E>
     *
     * @return
     */
    public static final <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("Set too big " + s);
        }
        return new AbstractList<Set<E>>() {
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }

            @Override
            public int size() {
                return 1 << src.size();
            }

            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Collection<?>) o);
            }
        };
    }
}
