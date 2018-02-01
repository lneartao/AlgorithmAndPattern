package com.general.lneartao.lib.designpattern.visitor;

/**
 * Created by lneartao on 2017/12/5.
 */

public class Unit {
    private Unit[] children;

    public Unit(Unit... units) {
        children = units;
    }

    public void accept(UnitVisitor unitVisitor) {
        for (Unit child : children) {
            child.accept(unitVisitor);
        }
    }
}
