package com.general.lneartao.lib.designpattern.composite;

import com.general.lneartao.lib.Logger;

/**
 * Created by lneartao on 2017/11/21.
 */

public class App {
    public static void main(String[] args) {
        Logger.printl("Message from the orcs: ");

        LetterComposite orcMessage = new Messenger().messageFromOrcs();
        orcMessage.print();

        Logger.printl("Message from the elves: ");

        LetterComposite elfMessage = new Messenger().messageFromElves();
        elfMessage.print();
    }
}
