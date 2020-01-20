package com.general.lneartao.lib.effectivejava.r6.i45;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * 谨慎地使用Stream
 * <p>
 * 滥用Stream会使程序代码更难以读懂和维护
 * 在没有显式类型的情况下，仔细命名Lambda参数，对于Stream pipeline的可读性至关重要
 * 在Stream pipeline中使用helper方法，对于可读性而言，避灾迭代化代码中使用更为重要
 * 最好避免使用Stream来处理char值 {@link Anagrams#charStreamError()}
 * 重构现有代码来使用Stream，并且只在必要的时候才在新代码中使用。
 * 注意：
 * 1. 从代码块中，可以读取或者修改范围内的任意局部变量，从Lambda则只能读取final或有效的final变量，并且不能修改任何local变量
 * 2. 从代码块中，可以从外围方法中return，break或continue外围循环，或者抛出该方法声明要抛出的任何受检异常；从Lambda中则完全无法完成这些事情
 * Stream可以完成的事情
 * 1. 统一转换元素的序列
 * 2. 过滤元素的序列
 * 3. 利用单个操作合并元素的顺序
 * 4. 将元素的序列存放到一个集合中，比如根据某些公共属性进行分组
 * 5. 搜索满足某些条件的元素的序列
 *
 * @author lneartao
 * @date 2020/1/20.
 */
public class Anagrams {

    public static void main(String[] args) {
//        method1(args);
//        method2(args);
        charStreamError();
    }

    /**
     * 这个会打印出数字
     */
    private static void charStreamError() {
        "Hello world".chars().forEach(System.out::print);
    }

    private static void charStreamCorrect() {
        "Hello world".chars().forEach(x -> System.out.print((char) x));
    }

    private static void method2(String[] args) {
        Path dictionary = Paths.get(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);
        try (Stream<String> words = Files.lines(dictionary)) {
            words.collect(groupingBy(Anagrams::alphabetize))
                 .values()
                 .stream()
                 .filter(group -> group.size() >= minGroupSize)
                 .forEach(g -> System.out.println(g.size() + ": " + g));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void method1(String[] args) {
        File dictionary = new File(args[0]);
        int minGroupSize = Integer.parseInt(args[1]);

        Map<String, Set<String>> groups = new HashMap<>();
        try (Scanner s = new Scanner(dictionary)) {
            while (s.hasNext()) {
                String word = s.next();
                groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= minGroupSize) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
