package com.general.lneartao.lib.refactor.rearrange;

/**
 * 以函数对象取代函数：将这个函数放进一个单独对象中，如此一来局部变量就成了对象内的字段。然后你可以在同一个对象中将这个大型函数分解为多个小型函数。
 *
 * @author lneartao
 * @date 2018/10/9.
 */
public class ReplaceMethodWithMethodObject {

    int gammaUgly(int inputVal, int quantity, int yearToDate) {
        int importantValue1 = (inputVal * quantity) + delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
        int importantValue3 = importantValue2 * 7;
        return importantValue3 - 2 * importantValue1;
    }

    int delta() {
        return 1;
    }

    int gamma(int inputVal, int quantity, int yearToDate) {
        return new Gamma(new Account(), inputVal, quantity, yearToDate).compute();
    }
}

class Gamma {

    private final Account account;
    private int inputVal;
    private int quantity;
    private int yearToDate;
    private int importantValue1;
    private int importantValue2;
    private int importantValue3;

    public Gamma(Account account, int inputVal, int quantity, int yearToDate) {
        this.account = account;
        this.inputVal = inputVal;
        this.quantity = quantity;
        this.yearToDate = yearToDate;
    }

    public int compute() {
        int importantValue1 = (inputVal * quantity) + account.delta();
        int importantValue2 = (inputVal * yearToDate) + 100;
        importantThing();
        int importantValue3 = importantValue2 * 7;
        return importantValue3 - 2 * importantValue1;
    }

    private void importantThing() {
        if ((yearToDate - importantValue1) > 100) {
            importantValue2 -= 20;
        }
    }
}

class Account {
    public int delta() {
        return 1;
    }
}
