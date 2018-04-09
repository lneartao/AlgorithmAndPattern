package com.general.lneartao.lib.puzzlers.p43;

/**
 * 通用类型信息是在编译期而非运行期检查的
 *
 * @author lneartao
 * @date 2018/4/3.
 */
public class TigerThrower<T extends Throwable> {
    public static void sneakyThrow(Throwable t) {
        new TigerThrower<Error>().sneakyThrow2(t);
    }

    private void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }
}
