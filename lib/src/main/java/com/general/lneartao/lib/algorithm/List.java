package com.general.lneartao.lib.algorithm;

/**
 * @author lneartao
 * @date 2018/2/6.
 */

public class List {

    /**
     * 两个非空linked lists 加两数
     * https://leetcode.com/problems/add-two-numbers/description/
     * 时间复杂度O(max(m,n)),空间复杂度O(max(m,n))
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        int carry = 0;
        ListNode prev = dummy;
        for (ListNode pa = l1, pb = l2; pa != null || pb != null; pa = pa == null ? null : pa.next, pb = pa == null ? null : pb.next, prev = prev.next) {
            final int ai = pa == null ? 0 : pa.val;
            final int bi = pb == null ? 0 : pb.val;
            final int val = (ai + bi + carry) % 10;
            carry = (ai + bi + carry) / 10;
            prev.next = new ListNode(val); // 尾插法
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }

    /**
     * 奇偶链表
     * https://leetcode.com/problems/odd-even-linked-list/description/
     * 时间复杂度O(nodes)，空间复杂度O(1)
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode dummyOdd = new ListNode(-1);
        ListNode dummyEven = new ListNode(-1);
        ListNode prevOdd = dummyOdd;
        ListNode prevEven = dummyEven;
        while (head != null) {
            prevOdd.next = new ListNode(head.val);
            prevOdd = prevOdd.next;
            head = head.next;
            if (head != null) {
                prevEven.next = new ListNode(head.val);
                prevEven = prevEven.next;
                head = head.next;
            }
        }
        prevOdd.next = dummyEven.next;
        return dummyOdd.next;
    }

    /**
     * https://leetcode.com/problems/intersection-of-two-linked-lists/
     * 比如 A={1,3,5,7,9,8}, b={2,4,9,8}
     * 算法：同时遍历A，B，当A到达尾端指向B，当B到达尾端指向A
     * A {1,3,5,7,9,8,2,4,9,8}
     * B {2,4,9,8,1,3,5,7,9,8}
     * 有重合即有交点节点，否则没有
     * 要把代码写出来还真的有点蛋疼，这里用count==2的小技巧来终止遍历
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersetionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int count = 0;
        ListNode hA = headA;
        ListNode hB = headB;
        while (count != 2) {
            if (hA.val == hB.val) {
                return hA;
            } else {
                if (hA.next == null) {
                    count++;
                    hA = headB;
                } else {
                    hA = hA.next;
                }
                if (hB.next == null) {
                    hB = headA;
                } else {
                    hB = hB.next;
                }
            }
        }
        return null;
    }
}
