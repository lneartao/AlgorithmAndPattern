package com.general.lneartao.lib.puzzlers;

/**
 * 包装类型在<=操作符上不是反对称的，因为==和!=在作用于对象引用时，执行的是引用的比较，而不是值的比较
 * （其实说到底是语言设计者留的坑）
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P32 {
    public static void main(String[] args) {

        // false
        System.out.println(new Integer(0) == new Integer(0));

        // true
        System.out.println(new Integer(0) == 0);

        Integer i = new Integer(0);
        Integer j = new Integer(0);
        while (i <= j && j <= i && i != j) {
            // 无限循环
        }

    }
}
