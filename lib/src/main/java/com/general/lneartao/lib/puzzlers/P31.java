package com.general.lneartao.lib.puzzlers;

/**
 * 这里还是宽窄数据类型自动转换的问题，原因在于-1的补码在转换类型的时候出现的问题
 * Java是否应该禁止在short、byte和char变量上使用复合赋值操作符
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P31 {
    public static void main(String[] args) {
        short i = -1;
        // byte = i = -1;
        // 无限循环
        while (i != 0) {
            i >>>= 1;
        }
    }
}
