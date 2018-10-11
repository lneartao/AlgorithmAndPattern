package com.general.lneartao.lib.refactor.remove;

/**
 * 提炼类：建立一个新类，将相关的字段和函数从旧类搬移到新类
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class ExtractClass {

    class PersonUgly {
        private String name;
        private String officeAreaCode;
        private String officeNumber;

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return ("(" + officeAreaCode + ")" + officeNumber);
        }

        public String getOfficeAreaCode() {
            return officeAreaCode;
        }

        public void setOfficeAreaCode(String officeAreaCode) {
            this.officeAreaCode = officeAreaCode;
        }

        public String getOfficeNumber() {
            return officeNumber;
        }

        public void setOfficeNumber(String officeNumber) {
            this.officeNumber = officeNumber;
        }
    }

    class Person {
        private String name;
        private TelephoneNumber officeTelephone = new TelephoneNumber();

        public String getName() {
            return name;
        }

        public String getTelephoneNumber() {
            return officeTelephone.getTelephoneNumber();
        }

        /**
         * 这里把对象暴露还是有风险的
         *
         * @return
         */
        public TelephoneNumber getOfficeTelephone() {
            return officeTelephone;
        }
    }

    class TelephoneNumber {
        private String number;
        private String areaCode;

        public String getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(String areaCode) {
            this.areaCode = areaCode;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getTelephoneNumber() {
            return ("(" + getAreaCode() + ")" + getNumber());
        }
    }
}
