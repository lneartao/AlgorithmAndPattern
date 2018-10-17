package com.general.lneartao.lib.refactor.simplify_method;

/**
 * @author lneartao
 * @date 2018/10/17.
 */
public class SeparateQueryFromModifier {

    private String foundMiscreant(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].equals("Don")) {
                sendAlert();
                return "Don";
            }
            if (people[i].equals("John")) {
                sendAlert();
                return "John";
            }
        }
        return "";
    }

    private void sendAlert() {

    }

    private void checkSecurity(String[] people) {
        String found = foundMiscreant(people);
        someLaterCode(found);
    }

    private void someLaterCode(String found) {

    }
}
