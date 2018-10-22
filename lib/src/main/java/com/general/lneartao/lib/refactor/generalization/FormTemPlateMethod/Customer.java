package com.general.lneartao.lib.refactor.generalization.FormTemPlateMethod;

import com.general.lneartao.lib.refactor.ex1.Rental;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 塑造模版函数：将这些操作分别放进独立函数中，并保持它们都有相同的签名，于是原函数也就变得相同了。然后将原函数上移至超类
 *
 * @author lneartao
 * @date 2018/10/22.
 */
public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }

    public double getTotalCharge() {
        double result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            result += rental.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }

    public List<Rental> getRentals() {
        return rentals;
    }
}
