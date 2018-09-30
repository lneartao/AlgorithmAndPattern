package com.general.lneartao.lib.refactor.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/9/29.
 */
public class Custom {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Custom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        Iterator<Rental> iterator = rentals.iterator();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (iterator.hasNext()) {
            Rental each = iterator.next();
            result.append("\t" + each.getMovie()
                                     .getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n");
        }
        result.append("Amount owed is " + String.valueOf(getTotalCharge()) + "\n");
        result.append("You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points");
        return result.toString();
    }

    private double getTotalCharge() {
        double result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            result += rental.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints(){
        int result = 0;
        Iterator<Rental> iterator = rentals.iterator();
        while (iterator.hasNext()) {
            Rental rental = iterator.next();
            result += rental.getFrequentRenterPoints();
        }
        return result;
    }
}
