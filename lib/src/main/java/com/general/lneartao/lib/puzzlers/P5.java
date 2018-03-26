package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * 混合类型的计算可能会产生混淆，应该尽量避免
 * 十进制字面常量都是正的，所以负数需要添加'-'标识
 * 而八进制和十六进制并不具备这个属性，只取决于最高位是否为1，所以就造成了下面的情况
 *
 * @author lneartao
 * @date 2018/3/26.
 */

public class P5 {
    public static void main(String[] args) {
        hexStringWrong();
        hexString();
    }

    /**
     * 后者实质为负数
     */
    private static void hexStringWrong() {
        Logger.printl(Long.toHexString(0x100000000L + 0xcafebabe));
    }

    /**
     * 后者实质为正数
     */
    private static void hexString() {
        Logger.printl(Long.toHexString(0x100000000L + 0xcafebabeL));
    }
}
