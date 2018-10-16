package com.general.lneartao.lib.refactor.simplify;

/**
 * @author lneartao
 * @date 2018/10/15.
 */
public class RemoveControlFlag {

    private void checkSecurityBreak(String[] people) {
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (!found) {
                if ("Don".equals(people[i])) {
                    sendAlert();
                    found = true;
                }
                if ("John".equals(people[i])) {
                    sendAlert();
                    found = true;
                }
            }
        }
    }

    private void checkSecurityReturn(String[] people) {
        boolean found = false;
        for (int i = 0; i < people.length; i++) {
            if (!found) {
                if ("Don".equals(people[i])) {
                    sendAlert();
                    found = true;
                }
                if ("John".equals(people[i])) {
                    sendAlert();
                    found = true;
                }
            }
        }
        someLaterCoder(found);
    }

    private void someLaterCoder(boolean found) {
        // do something else
    }

    private void sendAlert() {
        // do something else
    }
}
