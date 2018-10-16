package com.general.lneartao.lib.refactor.simplify;

/**
 * 移除控制标记：以break语句或return语句取代控制标记
 *
 * @author lneartao
 * @date 2018/10/15.
 */
public class RemoveControlFlag {

    private void checkSecurityBreak(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if ("Don".equals(people[i])) {
                sendAlert();
                break;
            }
            if ("John".equals(people[i])) {
                sendAlert();
                break;
            }
        }
    }

    private void checkSecurityReturn(String[] people) {
        String found = foundMiscreant(people);
        someLaterCoder(found);
    }

    private String foundMiscreant(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if ("Don".equals(people[i])) {
                sendAlert();
                return "Don";
            }
            if ("John".equals(people[i])) {
                sendAlert();
                return "John";
            }
        }
        return "";
    }

    private void someLaterCoder(String found) {
        // do something else
    }

    private void sendAlert() {
        // do something else
    }
}
