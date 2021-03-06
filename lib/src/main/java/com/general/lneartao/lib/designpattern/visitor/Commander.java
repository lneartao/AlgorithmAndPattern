package com.general.lneartao.lib.designpattern.visitor;

/**
 * Created by lneartao on 2017/12/5.
 */

public class Commander extends Unit {
    public Commander(Unit... units) {
        super(units);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visitCommander(this);
        super.accept(unitVisitor);
    }

    @Override
    public String toString() {
        return "Commander";
    }

}
