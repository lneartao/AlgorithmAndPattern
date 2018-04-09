package com.general.lneartao.lib.puzzlers;

import com.general.lneartao.lib.Logger;

import java.util.Calendar;
import java.util.Date;

/**
 * Date和Calendar Api中存在许多问题，如下
 * 还包括：Calendar其他的严重问题包括弱类型、过于复杂的状态空间、拙劣的结构、
 * 不一致的命名以及不一致的语义等，因此千万要记得查阅API文档
 * （新写的代码其实有没有从根本上解决问题的更好的替代类）
 *
 * @author lneartao
 * @date 2018/4/9.
 */
public class P61 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();

        // 12月在Calendar中的代表int值是11
//        cal.set(1999,12,31);
        cal.set(1999, Calendar.DECEMBER, 31);

        Logger.printl(cal.get(Calendar.YEAR) + " ");

        // 一些废弃的方法就要相当注意其的内在问题
        Date d = cal.getTime();
//        Logger.printl(d.getDay());

        Logger.printl(cal.get(Calendar.DAY_OF_MONTH));
    }
}
