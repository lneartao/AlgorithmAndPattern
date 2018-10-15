package com.general.lneartao.lib.refactor.reorganize_data;

/**
 * 以子类取代类型码：以子类取代这个类型码
 *
 * @author lneartao
 * @date 2018/10/12.
 */
public class ReplaceTypeCodeWithSubclasses {

}

class EmployeeUgly {
    private int type;
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    private EmployeeUgly(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    static EmployeeUgly create(int type) {
        return new EmployeeUgly(type);
    }
}

abstract class Employee {
    private int type;
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    Employee(int type) {
        this.type = type;
    }

    abstract int getType();

    static Employee create(int type) {
        switch (type) {
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new Salesman();
            case MANAGER:
                return new Manager();
            default:
                throw new IllegalArgumentException("Incorrect type code value");
        }
    }
}

class Engineer extends Employee {

    Engineer() {
        super(ENGINEER);
    }

    @Override
    public int getType() {
        return ENGINEER;
    }
}

class Salesman extends Employee {

    Salesman() {
        super(SALESMAN);
    }

    @Override
    public int getType() {
        return SALESMAN;
    }
}

class Manager extends Employee {

    Manager() {
        super(MANAGER);
    }

    @Override
    public int getType() {
        return MANAGER;
    }
}

