package com.general.lneartao.lib.designpattern.command;

import com.general.lneartao.lib.Logger;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lneartao on 2017/11/30.
 */

public class Wizard {
    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public Wizard() {
    }

    public void castSpell(Command command, Target target) {
        Logger.printl(this + " casts " + command + " at " + target);
        command.execute(target);
        undoStack.offerLast(command);
    }

    public void undoLastSpell() {
        if (!undoStack.isEmpty()) {
            Command previousSpell = undoStack.pollLast();
            redoStack.offerLast(previousSpell);
            Logger.printl(this + " undoes " + previousSpell);
            previousSpell.undo();
        }
    }

    public void redoLastSpell() {
        if (!redoStack.isEmpty()) {
            Command previousSpell = redoStack.pollLast();
            undoStack.offerLast(previousSpell);
            Logger.printl(this + " redoes " + previousSpell);
            previousSpell.redo();
        }
    }

    @Override
    public String toString() {
        return "Wizard";
    }
}
