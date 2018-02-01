package com.general.lneartao.lib.designpattern.command;

/**
 * Created by lneartao on 2017/11/30.
 */

public class InvisibilitySpell extends Command {
    private Target target;
    private Visibility oldVisibility;

    @Override
    public void execute(Target target) {
        oldVisibility = target.getVisibility();
        target.setVisibility(Visibility.INVISIBLE);
        this.target = target;
    }

    @Override
    public void undo() {
        if (target != null && target.getVisibility() != null) {
            Visibility visibility = target.getVisibility();
            target.setVisibility(oldVisibility);
            oldVisibility = visibility;
        }
    }

    @Override
    public void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "Invisibility Spell";
    }
}
