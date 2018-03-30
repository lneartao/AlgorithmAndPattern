package com.general.lneartao.lib.puzzlers;

/**
 * 这里有两个问题，分别是
 * +的优先级比==的高
 * 应该使用equal方法而不是==判断对象的相等与否
 *
 * @author lneartao
 * @date 2018/3/27.
 */

public class P13 {
    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();
        System.out.println("Animals are equal: " + pig == dog);

        // 上面的表达式等价于这个表达式
//        System.out.println(("Animals are equal: " + pig) == dog);

        //这个是正确的方法
//        System.out.println("Animals are equal: " + pig.equals(dog));
    }
}
