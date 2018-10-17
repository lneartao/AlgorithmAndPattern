package com.general.lneartao.lib.refactor.simplify_method;

/**
 * @author lneartao
 * @date 2018/10/16.
 */
public class RenameMethod {

    private int officeAreaCode;
    private int officeAreaNum;

    public String getTelephoneNumber() {
        return ("(" + officeAreaCode + ")" + officeAreaNum);
    }
}
