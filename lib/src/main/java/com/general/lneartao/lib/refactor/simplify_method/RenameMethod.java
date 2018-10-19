package com.general.lneartao.lib.refactor.simplify_method;

/**
 * 函数改名：修改函数名称
 *
 * @author lneartao
 * @date 2018/10/16.
 */
public class RenameMethod {

    private int officeAreaCode;
    private int officeAreaNum;

    public String getOfficeTelephoneNumber() {
        return ("(" + officeAreaCode + ")" + officeAreaNum);
    }
}
