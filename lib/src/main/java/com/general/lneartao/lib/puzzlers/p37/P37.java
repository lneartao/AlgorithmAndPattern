package com.general.lneartao.lib.puzzlers.p37;

import com.general.lneartao.lib.Logger;

/**
 * @author lneartao
 * @date 2018/4/2.
 */
public class P37 implements Type3 {

    /*
    无法编译
    如果一个catch子句要捕获一个类型为E的受检异常，而其相对应的try子句不能抛出E的某种子类型的异常，
    那么这就是一个编译期错误
    */
    /*public static void main(String[] args) {
        try {
            Logger.printl("Hello world");
        } catch (IOException e) {
            Logger.printl("I've never seen println fial!");
        }
    }*/

    // 可以通过编译
    /*public static void main(String[] args) {
        try {
            // If you have nothing nice to say, say nothing
//            throw new NullPointerException();
//            throw new Error();
        }catch (Exception e){
            Logger.printl("This can't happen");
        }
    }*/

    @Override
    public void f() {
        Logger.printl("Hello world");
    }

    // 说明了多个继承而来的throws子句的交集，将减少而不是增加方法允许抛出的异常数量
    public static void main(String[] args) {
        Type3 type3 = new P37();
        type3.f();
    }
}
