package com.general.lneartao.lib.designpattern.composite;

import com.general.lneartao.lib.Logger;

import java.util.List;

/**
 * Created by lneartao on 2017/11/21.
 */

public class Sentence extends LetterComposite {
    public Sentence(List<Word> words) {
        for (Word w : words) {
            this.add(w);
        }
    }

    @Override
    protected void printThisAfter() {
        Logger.printl(" ");
    }
}
