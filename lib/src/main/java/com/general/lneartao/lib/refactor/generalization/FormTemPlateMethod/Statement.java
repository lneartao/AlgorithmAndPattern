package com.general.lneartao.lib.refactor.generalization.FormTemPlateMethod;

import com.general.lneartao.lib.refactor.ex1.Rental;

import java.util.Iterator;

/**
 * @author lneartao
 * @date 2018/10/22.
 */
abstract class Statement {

    public String value(Customer customer) {
        Iterator<Rental> iterator = customer.getRentals().iterator();
        String result = headerString(customer);
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result += eachRentalString(each);
        }
        result += footerString(customer);
        return result;
    }

    protected abstract String footerString(Customer customer);

    protected abstract String eachRentalString(Rental each);

    protected abstract String headerString(Customer customer);

}
