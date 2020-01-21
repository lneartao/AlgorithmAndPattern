package com.general.lneartao.lib.effectivejava.r6.i47;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lneartao
 * @date 2020/1/21.
 */
public class SubLists {
    /**
     * 返回一个输入列表的所有相邻子列表
     *
     * @param list
     * @param <E>
     *
     * @return
     */
    public static <E> Stream<List<E>> of(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
                             prefixes(list).flatMap(SubLists::suffixes));
    }

    public static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size()).mapToObj(end -> list.subList(0, end));
    }

    public static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size()).mapToObj(start -> list.subList(start, list.size()));
    }
}
