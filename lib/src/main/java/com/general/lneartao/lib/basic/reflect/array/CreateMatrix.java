package com.general.lneartao.lib.basic.reflect.array;

import java.lang.reflect.Array;

/**
 * 创建多维数组
 *
 * @author lneartao
 * @date 2018/6/4.
 */
public class CreateMatrix {
    public static void main(String[] args) {
        init1();
//        init2();
    }

    /**
     * 推荐使用这种方法
     */
    private static void init1() {
        Object matrix = Array.newInstance(int.class, 2, 2);
        Object row0 = Array.get(matrix, 0);
        Object row1 = Array.get(matrix, 1);

        Array.setInt(row0, 0, 1);
        Array.setInt(row0, 1, 2);
        Array.setInt(row1, 0, 3);
        Array.setInt(row1, 1, 4);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("matrix[%d][%d] = %d%n", i, j, ((int[][]) matrix)[i][j]);
            }
        }
    }

    /**
     * 这里报错诶~
     */
    private static void init2() {
        Object matrix = Array.newInstance(int.class, 2);
        Object row0 = Array.newInstance(int.class, 2);
        Object row1 = Array.newInstance(int.class, 2);

        Array.setInt(row0, 0, 1);
        Array.setInt(row0, 1, 2);
        Array.setInt(row1, 0, 3);
        Array.setInt(row1, 1, 4);

        Array.set(matrix, 0, row0);
        Array.set(matrix, 1, row1);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.printf("matrix[%d][%d] = %d%n", i, j, ((int[][]) matrix)[i][j]);
            }
        }
    }
}
