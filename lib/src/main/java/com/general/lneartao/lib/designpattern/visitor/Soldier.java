package com.general.lneartao.lib.designpattern.visitor;

/**
 * Created by lneartao on 2017/12/5.
 */

public class Soldier extends Unit {
    public Soldier(Unit... units) {
        super(units);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visitSoldier(this);
        super.accept(unitVisitor);
    }

    @Override
    public String toString() {
        return "Soldier";
    }
}
