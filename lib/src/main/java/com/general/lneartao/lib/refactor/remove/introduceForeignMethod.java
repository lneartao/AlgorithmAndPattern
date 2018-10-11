package com.general.lneartao.lib.refactor.remove;

import java.util.Date;

/**
 * 引入外加函数：在客户类中建立一个函数，并以第一参数形式传入一个服务类实例
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class introduceForeignMethod {
    Date previousEnd = new Date();
    Date newStartUgly =
            new Date(previousEnd.getYear(), previousEnd.getMonth(), previousEnd.getDate() + 1);

    Date newStart = nextDate(previousEnd);

    /**
     * 外部方法，应该在Date类实现
     *
     * @param arg
     *
     * @return
     */
    private static Date nextDate(Date arg) {
        return new Date(arg.getYear(), arg.getMonth(), arg.getDate() + 1);
    }
}
