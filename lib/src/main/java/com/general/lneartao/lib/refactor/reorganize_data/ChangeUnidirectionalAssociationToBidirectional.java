package com.general.lneartao.lib.refactor.reorganize_data;


import java.util.HashSet;
import java.util.Set;

/**
 * 将单向关联改为双向关联：添加一个反向指针，并使修改函数能够同时更新两条连接
 *
 * @author lneartao
 * @date 2018/10/11.
 */
public class ChangeUnidirectionalAssociationToBidirectional {
    class Customer {
        private Set<Order> orders = new HashSet<>();

        Set friendOrders() {
            return orders;
        }

        void addOrder(Order order) {
            order.addCustomer(this);
        }

        void removeOrder(Order order) {
            order.removeCustomer(this);
        }
    }

    class Order {
        private Set<Customer> customers = new HashSet<>();

        void addCustomer(Customer customer) {
            customer.friendOrders().add(this);
            customers.add(customer);
        }

        void removeCustomer(Customer customer) {
            customer.friendOrders().remove(this);
            customers.remove(customer);
        }
    }
}
