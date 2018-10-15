package com.general.lneartao.lib.refactor.reorganize_data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 将值对象改为引用对象：将这个值对象变成引用对象
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class ChangeValueToReference {

    class Order {
        private Customer customer;

        public Order(String name) {
            this.customer = Customer.getNamed(name);
        }

        public String getCustomerName() {
            return customer.getName();
        }

        public void setCustomer(String name) {
            this.customer = Customer.getNamed(name);
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

class Customer {
    private final String name;
    private static Map<String, Customer> instance = new HashMap<>();

    static void loadCustomers() {
        new Customer("Lemon Car Hire").store();
        new Customer("Associated Coffee Machines").store();
        new Customer("Bilston Gasworks").store();
    }

    public static Customer getNamed(String name) {
        return instance.get(name);
    }

    private Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void store() {
        instance.put(getName(), this);
    }
}
