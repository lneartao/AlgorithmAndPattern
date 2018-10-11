package com.general.lneartao.lib.refactor.remove;

import java.util.Date;

/**
 * 引入本地扩展：建立一个新类，使它包含这些额外函数。让这个扩展品成为源类的子类或包装类
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class IntroduceLocalExtension {

    class MfDateSub extends Date {
        public MfDateSub(String s) {
            super(s);
        }

        /**
         * 转型构造函数
         *
         * @param date
         */
        public MfDateSub(Date date) {
            super(date.getTime());
        }

        public Date nextDay(Date arg) {
            return new Date(getYear(), getMonth(), getDate() + 1);
        }
    }

    /**
     * 需要为原始类的所有函数提供委托函数，比较麻烦~
     */
    class MfDateWrap {
        private Date original;

        public MfDateWrap(String dateString) {
            original = new Date(dateString);
        }

        /**
         * 转型构造函数
         *
         * @param date
         */
        public MfDateWrap(Date date) {
            original = date;
        }

        public int getYear() {
            return original.getYear();
        }

        public int getMonth() {
            return original.getMonth();
        }

        public int getDate() {
            return original.getDate();
        }

        /**
         * 这里会存在 a.equals(b) 和b.equals(a) 结果不一致的情况
         *
         * @param o
         *
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof MfDateWrap)) {
                return false;
            }
            MfDateWrap other = (MfDateWrap) o;
            return original.equals(other.original);
        }

        public Date nextDay(Date arg) {
            return new Date(getYear(), getMonth(), getDate() + 1);
        }
    }
}
