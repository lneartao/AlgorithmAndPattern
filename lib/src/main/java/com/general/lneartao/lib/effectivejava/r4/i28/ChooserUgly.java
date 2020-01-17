package com.general.lneartao.lib.effectivejava.r4.i28;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 这个类不好的原因在于，每次使用choose方法的时候都需要强制类型转换，如果搞错了类型，转换就会在运行时失败。
 * @author lneartao
 * @date 2020/1/17.
 */
public class ChooserUgly {
    private final Object[] choiceArray;

    public ChooserUgly(Collection choices) {
        this.choiceArray = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}
