package com.general.lneartao.lib;

import static com.general.lneartao.lib.Logger.printl;

/**
 * Created by lneartao on 2017/11/16.
 */

public class OtherThings {

    public static void main(String[] args) {
//        int x = 1;
//        printl(x == 1 ? true : false);
//        understandConstantString();
        printl(testFinally2());
    }

    /*
        让外部的循环条件表达式的结果可以受到里层循环体代码的控制 found
    */
    public void breakOuter() {
        int[][] arr = {{1, 2, 3}, {3, 4, 5, 6}, {9}};
        boolean found = false;
        for (int i = 0; i < arr.length && !found; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                printl("i= " + i + ", j= " + j);
                if (arr[i][j] == 5) {
                    found = true;
                    break;
                }
            }
        }
    }

    public void typeCastError() {
        short s1 = 1;
//        s1 = s1+1;  // 这个会提示类型错误
        short s2 = 1;
        s2 += 1;      // 这个不会是因为java编译器对它进行了特殊处理
    }

    public void getClassName() {
        super.getClass().getName();                         // 子类的类名
        super.getClass().getSimpleName();                   // 之类的包类名
        super.getClass().getSuperclass().getName();         // 父类的类名
        super.getClass().getSuperclass().getSimpleName();   // 父类的包类名
    }

    /*
        s3和s说明了java编译可以对字符串常量直接相加的表达式进行了优化，不必等到运行期去进行加法运算处理，
        而是在编译时去掉其中的加号，直接将其编译成一个常量相连的结果
    */
    public static void understandConstantString() {
        String s1 = "a";
        String s2 = s1 + "b";
        String s3 = "a" + "b";
        printl(s2 == "ab");
        printl(s3 == "ab");
        String s = "a" + "b" + "c";
        printl(s == "abc");
    }

    // finally 在 return 中间执行～
    public static int testFinally1() {
        int x = 1;
        try {
            return x;
        } finally {
            ++x;
        }
    }

    public static int testFinally2() {
        try {
            printl("func1");
            return 1;
        } finally {
            printl("func2");
            return 2;
        }
    }
}
