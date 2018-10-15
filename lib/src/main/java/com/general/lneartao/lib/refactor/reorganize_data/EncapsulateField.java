package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 封装字段：将它声明为private，并提供相应的访问字段
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class EncapsulateField {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
