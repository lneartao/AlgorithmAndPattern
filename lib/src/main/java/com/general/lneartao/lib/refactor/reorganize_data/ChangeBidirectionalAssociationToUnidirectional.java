package com.general.lneartao.lib.refactor.reorganize_data;

import java.util.HashSet;
import java.util.Set;

/**
 * 将双向关联改为单向关联：去除不必要的关联
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class ChangeBidirectionalAssociationToUnidirectional {

    class Order {
        private Customer customer;
        private int grossPrice;

        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            this.customer.friendOrders().remove(this);
            this.customer = customer;
            this.customer.friendOrders().add(this);
        }

        public int getGrossPrice() {
            return grossPrice;
        }

        public void setGrossPrice(int grossPrice) {
            this.grossPrice = grossPrice;
        }

        double getDiscountedPriceUgly() {
            return getGrossPrice() * (1 - customer.getDiscount());
        }

        double getDiscountedPrice(Customer customer) {
            return getGrossPrice() * (1 - customer.getDiscount());
        }
    }

    class Customer {
        private Set<Order> orders = new HashSet<>();
        private int discount;

        Set<Order> friendOrders() {
            return orders;
        }

        void addOrder(Order order) {
            order.setCustomer(this);
        }

        public int getDiscount() {
            return discount;
        }

        public void setDiscount(int discount) {
            this.discount = discount;
        }

        double getPriceForUgly(Order order) {
            return order.getDiscountedPriceUgly();
        }

        double getPriceFor(Order order) {
            return order.getDiscountedPrice(this);
        }
    }
}
