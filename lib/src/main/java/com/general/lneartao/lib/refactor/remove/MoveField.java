package com.general.lneartao.lib.refactor.remove;

/**
 * 搬移字段：在目标类新建一个字段，修改源字段的所有用户，令它们改用新字段
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class MoveField {
    class Account {
        private AccountType type;
        private double interestRate;

        double interestForAmountDaysUgly(double amount, int days) {
            return interestRate * amount * days / 365;
        }

        double interestForAmountDays(double amount, int days) {
            return type.getInterestRate() * amount * days / 365;
        }
    }

    class AccountType {
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
    }
}


