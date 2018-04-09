package com.general.lneartao.lib.puzzlers.p78_2;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.puzzlers.p78_1.Api;

/**
 * @author lneartao
 * @date 2018/4/9.
 */
public class Client {
    public static void main(String[] args) {
//        Logger.printl(Api.member.hashCode());
        // 修正
        Logger.printl(((Object) Api.member).hashCode());
    }
}
