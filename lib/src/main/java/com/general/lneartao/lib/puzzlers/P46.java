package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

/**
 * Java的重载解析过程是以两阶段运行的。
 * 第一阶段选取所有可获得并且可应用的方法或构造器
 * 第二阶段是在第一阶段选取的方法或构造器中选取最精确的一个
 * 如果一个方法或构造器可以接受传递给另一个方法或构造器的任何参数，那么我们就说第一给方法比第二个方法缺乏精确性
 * 该例子中，P46(Object)可以接受任何传递给P46(double[])的参数，因此P46(Object)缺乏精确性，可以通过强制类型转换赋值
 * 理想状态下，应该避免使用重载：为不同的方法取不同的名称，可以考虑使用静态工厂和Builder模式
 * 如果确实进行了重载，那么请确保所有的重载版本所接受的参数类型都互不兼容
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class P46 {
    private P46(Object o) {
        Logger.printl("Object");
    }

    private P46(double[] dArray) {
        Logger.printl("double array");
    }

    public static void main(String[] args) {
        new P46(null);
        new P46((Object) null);
    }
}
