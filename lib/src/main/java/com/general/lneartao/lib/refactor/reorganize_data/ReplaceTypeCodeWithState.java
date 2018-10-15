package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 以State/Strategy取代类型码：以状态对象取代类型码
 *
 * @author lneartao
 * @date 2018/10/12.
 */
public class ReplaceTypeCodeWithState {

}

abstract class EmployeeType {

    abstract int getTypeCode();

    abstract int payAmount();

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    static EmployeeType newType(int type) {
        switch (type) {
            case ENGINEER:
                return new Engineer2();
            case MANAGER:
                return new Manager2();
            case SALESMAN:
                return new Salesman2();
            default:
                throw new IllegalArgumentException("Incorrect Employee Code");
        }
    }
}

class Employee2 {
    private EmployeeType type;

    private Employee2(int type) {
        setType(type);
    }

    public int getType() {
        return type.getTypeCode();
    }

    public void setType(int code) {
        type = EmployeeType.newType(code);
    }

    int payAmountUgly() {
        switch (getType()) {
            case EmployeeType.ENGINEER:
                return 1;
            case EmployeeType.SALESMAN:
                return 2;
            case EmployeeType.MANAGER:
                return 3;
            default:
                return 4;
        }
    }

    int payAmount() {
        return type.getTypeCode();
    }
}

class Engineer2 extends EmployeeType {
    @Override
    int getTypeCode() {
        return ENGINEER;
    }

    @Override
    int payAmount() {
        return 1;
    }
}

class Manager2 extends EmployeeType {
    @Override
    int getTypeCode() {
        return MANAGER;
    }

    @Override
    int payAmount() {
        return 3;
    }
}

class Salesman2 extends EmployeeType {
    @Override
    int getTypeCode() {
        return SALESMAN;
    }

    @Override
    int payAmount() {
        return 2;
    }
}


