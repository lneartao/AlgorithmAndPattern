package com.general.lneartao.lib.effectivejava.r3;

/**
 * 限制源文件为单个顶级类
 * <p>
 * 如果在一个源文件中定义多个顶级类，可能导致给一个类提供多个定义。哪一个定义会被用到，取决于源文件被传给编译器的顺序。
 * 原则：永远不要把多个顶级类或接口放在一个源文件中
 * <p>
 * 不要像下面这么做，要么分开两个源文件，要么把其中一个定义为静态成员类。
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public class I25 {

    class Utensil {
        static final String NAME = "utensil";
    }

    class Dessert {
        static final String NAME = "dessert";
    }
}
