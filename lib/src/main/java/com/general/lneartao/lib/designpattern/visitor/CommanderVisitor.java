package com.general.lneartao.lib.designpattern.visitor;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/12/5.
 */

public class CommanderVisitor implements UnitVisitor {
    @Override
    public void visitSoldier(Soldier soldier) {

    }

    @Override
    public void visitSergeant(Sergeant sergeant) {

    }

    @Override
    public void visitCommander(Commander commander) {
        Logger.printl("Good to see you " + commander);
    }
}
