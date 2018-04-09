package com.general.lneartao.lib.puzzlers.p70_2;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.puzzlers.p70_1.CodeTalk;

/**
 * 一个包内私有方法不能被位于另一个包中的某个方法直接覆写，这两个方法只是具有相同的名字
 * 因此覆写表明@Override是相当必要的
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class TypeIt {
    private static class ClickIt extends CodeTalk {
        void printMsg() {
            Logger.printl("Hack");
        }
    }

    public static void main(String[] args) {
        ClickIt clickIt = new ClickIt();
        clickIt.doIt();
    }
}
