package com.general.lneartao.lib.puzzlers;

import java.math.BigInteger;

/**
 * 不要被误导，认为不可变类型是可变的。
 * 教训：在命名不可变类型的方法时，应该优选介词和名词，而不是动词
 * 介词适用于带有参数的方法，而名词适用于不带参数的方法
 * @author lneartao
 * @date 2018/4/9.
 */
public class P56 {
    public static void main(String[] args) {
        wrongOne();
        correctOne();
    }

    private static void correctOne() {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger total = BigInteger.ZERO;
        total = total.add(fiveThousand);
        total = total.add(fiftyThousand);
        System.out.println(total);
    }

    private static void wrongOne() {
        BigInteger fiveThousand = new BigInteger("5000");
        BigInteger fiftyThousand = new BigInteger("50000");
        BigInteger total = BigInteger.ZERO;
        total.add(fiveThousand);
        total.add(fiftyThousand);
        System.out.println(total);
    }
}
