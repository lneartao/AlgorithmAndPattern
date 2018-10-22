package com.general.lneartao.lib.refactor.generalization.FormTemPlateMethod;

import com.general.lneartao.lib.refactor.ex1.Rental;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
public class TextStatement extends Statement {

    @Override
    protected String eachRentalString(Rental each) {
        return "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
    }

    @Override
    protected String headerString(Customer customer) {
        return "Rental Record for " + customer.getName() + "\n";
    }

    @Override
    protected String footerString(Customer customer) {
        return "Amount owed is " + String.valueOf(customer.getTotalCharge()) + "\n"
                + "You earned " + String.valueOf(customer.getTotalFrequentRenterPoints()) + " frequent renter points";

    }

}
