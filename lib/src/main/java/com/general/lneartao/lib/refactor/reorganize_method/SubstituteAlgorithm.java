package com.general.lneartao.lib.refactor.reorganize_method;

import java.util.Arrays;
import java.util.List;

/**
 * 替换算法：将函数本体替换为另一个算法
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class SubstituteAlgorithm {
    String foundPerson1(String[] people) {
        for (int i = 0; i < people.length; i++) {
            if ("Don".equals(people[i])) {
                return "Don";
            }
            if ("John".equals(people[i])) {
                return "John";
            }
            if ("Kent".equals(people[i])) {
                return "Kent";
            }
        }
        return "";
    }

    String foundPeople2(String[] people) {
        List candidates = Arrays.asList("Don", "John", "Kent");
        for (int i = 0; i < people.length; i++) {
            if (candidates.contains(people[i])) {
                return people[i];
            }
        }
        return "";
    }
}
