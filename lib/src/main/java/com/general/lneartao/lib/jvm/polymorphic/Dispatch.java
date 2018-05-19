package com.general.lneartao.lib.jvm.polymorphic;

import com.general.lneartao.lib.Logger;

/**
 * 单分派和多分派的演示
 * Java语言是一门静态多分派、动态单分派的语言。
 * <p>
 * 编译期：选择目标方法的依据有两点：一是静态类型Father or Son，二是方法参数是QQ or 360，有两个宗量
 * 产生两条invokevirtual指令，分别对应常量池中指向Father.hardChoice(360)和Father.hardChoice(QQ)方法的符号引用
 * <p>
 * 运行期：唯一影响选择的实际类型是Father or Son，只有一个宗量
 *
 * @author lneartao
 * @date 2018/5/17.
 */
public class Dispatch {
    static class QQ {

    }

    static class _360 {

    }

    public static class Father {
        public void hardChoice(QQ arg) {
            Logger.printl("father choose qq");
        }

        public void hardChoice(_360 arg) {
            Logger.printl("father choose 360");
        }
    }

    public static class Son extends Father {
        @Override
        public void hardChoice(QQ arg) {
            Logger.printl("son choose qq");
        }

        @Override
        public void hardChoice(_360 arg) {
            Logger.printl("son choose 360");
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());
    }
}
