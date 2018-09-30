package com.general.lneartao.lib.refactor.ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author lneartao
 * @date 2018/9/29.
 */
public class CustomerBeforeRefactor {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public CustomerBeforeRefactor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> iterator = rentals.iterator();
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");
        while (iterator.hasNext()) {
            double thisAmount = 0;
            Rental each = iterator.next();

            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2) {
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    }
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3) {
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    }
                    break;
                default:
            }

            frequentRenterPoints++;
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) {
                frequentRenterPoints++;
            }

            result.append("\t" + each.getMovie()
                                     .getTitle() + "\t" + String.valueOf(thisAmount) + "\n");
            totalAmount += thisAmount;
        }

        result.append("Amount owed is " + String.valueOf(totalAmount) + "\n");
        result.append("You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points");
        return result.toString();
    }
}
