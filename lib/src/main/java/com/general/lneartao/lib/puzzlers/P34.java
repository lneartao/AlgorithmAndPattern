package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 不要使用浮点数作为循环索引，因为它会导致无法预测的行为
 * 这里产生错误的原因是f的初始值太大了，以至于加上50后，结果转为float时，
 * 所产生的数值等于直接将f转换成float的数值
 *
 * @author lneartao
 * @date 2018/4/2.
 */
public class P34 {
    public static void main(String[] args) {
        final int start = 2000000000;
        int count = 0;
        for (float f = start; f < start + 50; f++) {
            count++;
        }
        Logger.printl(count);
    }
}
