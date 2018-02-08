package com.general.lneartao.lib.test;

import com.general.lneartao.lib.Logger;
import com.general.lneartao.lib.algorithm.List;
import com.general.lneartao.lib.algorithm.ListNode;

import java.util.Random;

/**
 * @author lneartao
 * @date 2018/2/7.
 */

public class TestList {

    public static void main(String[] args) {
//        testOddEvenList();
        testGetIntersectionNode();
    }

    public static void testGetIntersectionNode() {
        ListNode headA = createTestHead(4);
        printListHead(headA);
        ListNode headB = createTestHead(7);
        printListHead(headB);
        printListHead(new List().getIntersetionNode(headA, headB));
    }

    public static void testOddEvenList() {
        List list = new List();
        ListNode head = createTestHead(5);
        printListHead(head);
        printListHead(list.oddEvenList(head));
    }

    private static ListNode createTestHead(int size) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            head.setNext(new ListNode(random.nextInt(size)));
            head = head.getNext();
        }
        return dummy.getNext();
    }

    private static void printListHead(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.getVal());
            System.out.print("->");
            listNode = listNode.getNext();
        }
        Logger.printl("NULL");
    }
}
