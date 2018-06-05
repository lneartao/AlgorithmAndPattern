package com.general.lneartao.lib.basic.reflect.method;

import com.general.lneartao.lib.Logger;

/**
 * https://docs.oracle.com/javase/tutorial/reflect/member/methodparameterreflection.html
 * 程序输出的结果和文档的不一致啊！
 *
 * @author lneartao
 * @date 2018/6/1.
 */
public class MethodParameterExamples {

    /**
     * 这里就可以看出非静态内部类的构造器会自动添加外部类的引用
     */
    public class InnerClass {

        private String name;

        public InnerClass(String name) {
            this.name = name;
        }
    }

    enum Colors {
        RED, WHITE;
    }

    public static void main(String[] args) {
        Logger.printl("InnerClass: ");
        MethodParameterSpy.printClassConstructors(InnerClass.class);

        Logger.printl("enum Colors: ");
        MethodParameterSpy.printClassConstructors(Colors.class);
        MethodParameterSpy.printClassMethods(Colors.class);
    }
}
