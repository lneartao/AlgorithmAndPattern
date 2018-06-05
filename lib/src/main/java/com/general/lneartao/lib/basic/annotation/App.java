package com.general.lneartao.lib.basic.annotation;

/**
 * 作用：
 * 1、标记：用于告诉编译器一些信息
 * 2、编译时动态处理，如动态生成代码
 * 3、运行时动态处理，如得到注解信息
 *
 * @author lneartao
 * @date 2018/5/30.
 */
public class App {
    @MethodInfo(
            date = "2018/05/30"
    )
    public String getAppName() {
        return "trinea";
    }
}
