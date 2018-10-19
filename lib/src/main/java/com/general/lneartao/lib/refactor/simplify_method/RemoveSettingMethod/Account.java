package com.general.lneartao.lib.refactor.simplify_method.RemoveSettingMethod;

/**
 * 移除设值函数：去掉该字段的所有设值函数
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class Account {

    private String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
