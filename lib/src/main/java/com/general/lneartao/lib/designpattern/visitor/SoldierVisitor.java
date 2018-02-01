package com.general.lneartao.lib.designpattern.visitor;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/12/5.
 */

public class SoldierVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {
        Logger.printl("Greeting " + soldier);
    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {

    }
}
