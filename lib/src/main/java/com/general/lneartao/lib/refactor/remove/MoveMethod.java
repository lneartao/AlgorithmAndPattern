package com.general.lneartao.lib.refactor.remove;

/**
 * 搬移函数：在该函数最常引用的类中建立一个有着类似行为的新函数，将旧函数变成一个单纯的委托函数，或是将旧函数完全移除。
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class MoveMethod {
    class Account {
        private AccountType type;
        private int daysOverdrawn;

        double overdraftChargeUgly(int daysOverdrawn) {
            if (type.isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) {
                    result += (daysOverdrawn - 7) * 0.85;
                }
                return result;
            } else {
                return daysOverdrawn * 1.75;
            }
        }

        double overdraftCharge() {
            return type.overdraftCharge(daysOverdrawn);
        }
    }

    class AccountType {
        boolean isPremium() {
            return true;
        }

        double overdraftCharge(int daysOverdrawn) {
            if (isPremium()) {
                double result = 10;
                if (daysOverdrawn > 7) {
                    result += (daysOverdrawn - 7) * 0.85;
                }
                return result;
            } else {
                return daysOverdrawn * 1.75;
            }
        }
    }
}


