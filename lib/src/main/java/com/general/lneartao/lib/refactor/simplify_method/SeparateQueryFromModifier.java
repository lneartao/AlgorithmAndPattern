package com.general.lneartao.lib.refactor.simplify_method;

/**
 * 将查询函数和修改函数分离：建立两个不同的函数，其中一个负责查询，另一个负责修改
 * 任何有返回值的函数，都不应该有看得到的副作用
 *
 * @author lneartao
 * @date 2018/10/17.
 */
public class SeparateQueryFromModifier {

    /**
     * 修改函数
     *
     * @param people
     */
    private void sendAlert(String[] people) {
        if (!foundPerson(people).equals("")) {
            sendAlert();
        }
    }

    /**
     * 查询函数
     *
     * @param people
     *
     * @return
     */
    private String foundPerson(String[] people) {
        for (String aPeople : people) {
            if (aPeople.equals("Don")) {
                return "Don";
            }
            if (aPeople.equals("John")) {
                return "John";
            }
        }
        return "";
    }

    private void sendAlert() {

    }

    private void checkSecurity(String[] people) {
        sendAlert(people);
        String found = foundPerson(people);
        someLaterCode(found);
    }

    private void someLaterCode(String found) {

    }

}
