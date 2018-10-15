package com.general.lneartao.lib.refactor.reorganize_data;

import java.util.Collection;

/**
 * 以对象取代数据值：将数据项变成对象
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class ReplaceDataValueWithObject {

    class OrderUgly {
        private String customer;

        public OrderUgly(String customer) {
            this.customer = customer;
        }

        public String getCustomer() {
            return customer;
        }

        public void setCustomer(String customer) {
            this.customer = customer;
        }
    }

    private static int numberOfOrdersForUgly(Collection<OrderUgly> orders, String customer) {
        int result = 0;
        for (OrderUgly order : orders) {
            if (order.getCustomer().equals(customer)) {
                result++;
            }
        }
        return result;
    }

    class Customer {
        private final String name;

        public Customer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Order {
        private Customer customer;

        public Order(String name) {
            this.customer = new Customer(name);
        }

        public String getCustomerName() {
            return customer.getName();
        }

        public void setCustomer(String name) {
            this.customer = new Customer(name);
        }
    }

    private static int numberOfOrdersFor(Collection<Order> orders, String customer) {
        int result = 0;
        for (Order order : orders) {
            if (order.getCustomerName().equals(customer)) {
                result++;
            }
        }
        return result;
    }
}
