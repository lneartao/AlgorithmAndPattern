package com.general.lneartao.lib.practice.stack;

import java.util.Stack;

/**
 * LeetCode 232. Implement Queue using Stacks
 *
 * @author lneartao
 * @date 2020/1/19.
 */
public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stack1 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stack1.empty()) {
            return Integer.MIN_VALUE;
        } else {
            stack2 = new Stack<>();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            Integer result = stack2.pop();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stack1.empty()) {
            return Integer.MIN_VALUE;
        } else {
            stack2 = new Stack<>();
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            Integer result = stack2.peek();
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            return result;
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.empty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
