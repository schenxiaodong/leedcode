package com.cxd.algorithm.list;

/**
 * @author Administrator
 *
 * 项目需求 链表结构 1 -> 2 -> 3 -> 4 -> 5
 * 将链表反转
 */
public class ReverseList {
    /**
     * 定义表结构
     */
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 反转函数
     * 每一次获取当前元素，并将当前元素作为元素头进行头插法插入
     * 只是新增两个节点作为中间交换变量
     * prev 为每一次的头节点，
     * next 每次循环都指向待交换节点下一个节点，
     * 交换节点为curr 所指向的节点
     * @param head 输入的是链表的头节点
     * @return 返回新链表的头节点
     */
    public static ListNode iterate(ListNode head) {
        ListNode prev = null, next;
        ListNode curr = head;

        while (curr != null) {
            // 获取下一个元素
            next = curr.next;
            curr.next = prev;
            prev = curr;
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
