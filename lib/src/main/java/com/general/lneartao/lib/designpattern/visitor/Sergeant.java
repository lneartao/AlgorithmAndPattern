package com.general.lneartao.lib.designpattern.visitor;

/**
 * Created by lneartao on 2017/12/5.
 */

public class Sergeant extends Unit {
    public Sergeant(Unit... units) {
        super(units);
    }

    @Override
    public void accept(UnitVisitor unitVisitor) {
        unitVisitor.visitSergeant(this);
        super.accept(unitVisitor);
    }

    @Override
    public String toString() {
        return "Sergeant";
    }
}
