package com.general.lneartao.lib.refactor.remove;

/**
 * 隐藏委托关系：在服务类上建立客户所需的所有函数，用以隐藏委托关系
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class HideDelegate {
    class Person {
        Department department;

        public Department getDepartment() {
            return department;
        }

        public void setDepartment(Department department) {
            this.department = department;
        }

        /**
         * 这里就使用了隐藏委托关系
         *
         * @return
         */
        public Person getManager() {
            return department.getManager();
        }
    }

    class Department {
        private String chargeCode;
        private Person manager;

        public Department(Person manager) {
            this.manager = manager;
        }

        public Person getManager() {
            return manager;
        }
    }
}
