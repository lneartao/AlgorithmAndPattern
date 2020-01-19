package com.general.lneartao.lib.effectivejava.r5.i34;

/**
 * @author lneartao
 * @date 2020/1/19.
 */
public enum PayrollDay {

    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
    SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

    private final PayType payType;

    PayrollDay() {
        this(PayType.WEEKDAY);
    }

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    int pay(int mins, int payRate) {
        return payType.pay(mins, payRate);
    }

    private enum PayType {
        WEEKDAY {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            @Override
            int overtimePay(int mins, int payRate) {
                return mins * payRate / 2;
            }
        };

        private static final int MINS_PER_SHIFT = 8 * 60;

        abstract int overtimePay(int mins, int payRate);

        int pay(int mins, int payRate) {
            int basePay = mins * payRate;
            return basePay + overtimePay(mins, payRate);
        }
    }
}
