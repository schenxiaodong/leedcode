package com.cxd.algorithm.list;

/**
 * @author Administrator
 */
public class ReverseList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;
        /**
         * 1 2 3 4 5
         */
        while (curr != null) {
            // 获取下一个元素
            next = curr.next;
            // 将 prev 赋值给curr.next
            curr.next = prev;
            // 将 curr 赋值给 prev
            prev = curr;
            // curr 又等于下一个值
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode iterate = iterate(node1);
        int a = 0;
    }
}
