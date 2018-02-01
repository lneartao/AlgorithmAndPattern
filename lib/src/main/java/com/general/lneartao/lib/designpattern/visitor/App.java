package com.general.lneartao.lib.designpattern.visitor;

/**
 * Created by lneartao on 2017/12/5.
 */

public class App {
    public static void main(String[] args) {
        Commander commander =
                new Commander(new Sergeant(new Soldier(), new Soldier(), new Soldier()), new Sergeant(
                        new Soldier(), new Soldier(), new Soldier()));
        commander.accept(new SoldierVisitor());
        commander.accept(new SergeantVisitor());
        commander.accept(new CommanderVisitor());
    }
}
