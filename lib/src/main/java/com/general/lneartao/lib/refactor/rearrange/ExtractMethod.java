package com.general.lneartao.lib.refactor.rearrange;

import com.general.lneartao.lib.Logger;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 提炼函数：将这段代码放进一个独立函数中，并让函数名称解释该函数的用途
 *
 * @author lneartao
 * @date 2018/10/8.
 */
public class ExtractMethod {

    Set<Order> mOrders = new HashSet<>();
    String mName = "name";

    void printOwingUgly() {
        Iterator<Order> i = mOrders.iterator();
        double outstanding = 0.0;

        // print banner
        Logger.printl("*************************");
        Logger.printl("****** Custom Owes ******");
        Logger.printl("*************************");

        // calculate outstanding
        while (i.hasNext()) {
            Order each = i.next();
            outstanding += each.getAmount();
        }

        // print details
        Logger.printl("name: " + mName);
        Logger.printl("amount: " + outstanding);
    }

    void printOwing() {
        printBanner();
        double outstanding = getOutstanding();
        printDetails(outstanding);
    }

    private double getOutstanding() {
        Iterator<Order> i = mOrders.iterator();
        double result = 0.0;
        // calculate outstanding
        while (i.hasNext()) {
            Order each = i.next();
            result += each.getAmount();
        }
        return result;
    }

    /**
     * print details
     *
     * @param outstanding
     */
    private void printDetails(double outstanding) {
        Logger.printl("name: " + mName);
        Logger.printl("amount: " + outstanding);
    }

    /**
     * print banner
     */
    private void printBanner() {
        Logger.printl("*************************");
        Logger.printl("****** Custom Owes ******");
        Logger.printl("*************************");
    }
}
