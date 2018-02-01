package com.general.lneartao.lib.designpattern.composite;

import java.util.List;

/**
 * Created by lneartao on 2017/11/21.
 */

public class Word extends LetterComposite {

    public Word(List<Letter> letters) {
        for (Letter l : letters) {
            this.add(l);
        }
    }

    @Override
    protected void printThisBefore() {
        System.out.print(" ");
    }
}
