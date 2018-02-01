package com.general.lneartao.lib.designpattern.composite;

/**
 * Created by lneartao on 2017/11/21.
 */

public class Letter extends LetterComposite {
    private char c;

    public Letter(char c) {
        this.c = c;
    }

    @Override
    protected void printThisBefore() {
        System.out.print(c);
    }
}
