package com.general.lneartao.lib.practice.linkedlist;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * @author lneartao
 * @date 2020/1/16.
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     *
     * @param head
     *
     * @return
     */
    public static ListNode reverse(ListNode head) {
        // 利用哨兵结点
        ListNode sentinel = new ListNode(-1);
        ListNode cur = head;
        ListNode node;
        while (cur != null) {
            node = new ListNode(cur.val);
            node.next = sentinel.next;
            sentinel.next = node;
            cur = cur.next;
        }
        return sentinel.next;

//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode nextTemp = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = nextTemp;
//        }
//        return prev;

//        if (head == null || head.next == null) return head;
//        ListNode p = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return p;
    }

    /**
     * 链表中环的检测
     * 方法一：利用了HashMap存储的对象唯一性（不重写对象的equals和hashCode方法），保存当前节点的前驱，然后查询是否已插入HashMap可得结果
     * 方法二：有点像在操场跑步，如果一个人比另一个人快一倍，那么如果有环，那么他们总会相遇
     *
     * @param head
     *
     * @return
     */
    public static boolean checkCircle(ListNode head) {
        // 方法一
//        ListNode sentinel = new ListNode(-1);
//        sentinel.next = head;
//        HashMap<ListNode, ListNode> cache = new HashMap<>();
//        while (sentinel.next != null) {
//            if (cache.get(sentinel.next) == null) {
//                cache.put(sentinel.next, sentinel);
//            } else {
//                return true;
//            }
//            sentinel = sentinel.next;
//        }
//        return false;

        // 方法二
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 两个有序的链表合并
     *
     * @param l1
     * @param l2
     *
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 利用哨兵结点
        ListNode sentinel = new ListNode(-1);
        ListNode head = sentinel;
        ListNode l1Cur = l1;
        ListNode l2Cur = l2;

        while (l1Cur != null && l2Cur != null) {
            if (l1Cur.val > l2Cur.val) {
                sentinel.next = l2Cur;
                l2Cur = l2Cur.next;
            } else {
                sentinel.next = l1Cur;
                l1Cur = l1Cur.next;
            }
            sentinel = sentinel.next;
        }
        if (l1Cur != null) {
            sentinel.next = l1Cur;
        }
        if (l2Cur != null) {
            sentinel.next = l2Cur;
        }
        return head.next;
    }

    /**
     * 删除倒数第K个结点
     *
     * @param head
     * @param n
     *
     * @return
     */
    public static ListNode deleteLastKth(ListNode head, int n) {
//        ListNode reverse = reverse(head);
//        ListNode sentinel = new ListNode(-1);
//        sentinel.next = reverse;
//        ListNode pre = sentinel;
//        int i = 1;
//        while (pre.next != null && i != n) {
//            pre = pre.next;
//            i++;
//        }
//        if (pre.next == null) {
//            return null;
//        } else {
//            pre.next = pre.next.next;
//            return reverse(sentinel.next);
//        }

        // 这个快很多
        ListNode fast = head;
        int i = 1;
        while (fast != null && i < n) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return head;
        }

        ListNode slow = head;
        ListNode prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            head = head.next;
        } else {
            prev.next = prev.next.next;
        }
        return head;
    }

    /**
     * 求链表的中间结点
     *
     * @param head
     *
     * @return
     */
    public static ListNode findMiddleNode(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast.next != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        if (fast.next == null) {
//            return slow;
//        } else {
//            return slow.next;
//        }

        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void printAll(ListNode list) {
        ListNode p = list;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static ListNode createNode(int value) {
        return new ListNode(value);
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        testReverse();
//        testMerge();
//        testDeleteK();
//        testMiddleK();
        testCycle();
    }

    private static void testCycle() {
        System.out.println(checkCircle(createCycleNode(0, 1, 2)));
        System.out.println(checkCircle(createCycleNode(1, 3, 2, 0, -4)));
        System.out.println(checkCircle(createCycleNode(-1, 1)));
    }

    private static void testMiddleK() {
        printAll(findMiddleNode(createNode(1)));
        printAll(findMiddleNode(createNode(1, 2)));
        printAll(findMiddleNode(createNode(1, 2, 3, 4, 5)));
        printAll(findMiddleNode(createNode(1, 2, 3, 4, 5, 6)));
    }

    private static void testDeleteK() {
        printAll(deleteLastKth(createNode(1, 2, 3, 4, 5), 5));
    }

    private static void testMerge() {
        printAll(mergeTwoLists(new ListNode(2), new ListNode(1)));
        printAll(mergeTwoLists(new ListNode(5), createNode(1, 2, 4)));
    }

    private static void testReverse() {
        testNull();
        test1();
        test2();
        test3();
        test5();
    }

    private static void testNull() {
        printAll(reverse(null));
    }

    private static void test1() {
        printAll(reverse(new ListNode(1)));
    }

    private static void test2() {
        printAll(reverse(createNode(1, 2)));
    }

    private static void test3() {
        printAll(reverse(createNode(1, 2, 3)));
    }

    private static void test5() {
        printAll(reverse(createNode(1, 2, 3, 4, 5)));
    }

    /**
     * 创建无环单链表
     *
     * @param vales
     *
     * @return
     */
    private static ListNode createNode(int... vales) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (int vale : vales) {
            node.next = new ListNode(vale);
            node = node.next;
        }
        return head.next;
    }

    /**
     * 创建有环单链表
     *
     * @param pos 第几个位置成环
     * @param vales
     *
     * @return
     */
    private static ListNode createCycleNode(int pos, int... vales) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        ListNode loopNode = null;
        for (int i = 0; i < vales.length; i++) {
            node.next = new ListNode(vales[i]);
            node = node.next;
            if (i == pos) {
                loopNode = node;
            }
        }
        node.next = loopNode;
        return head.next;
    }
}
