package com.cxd.algorithm.dataStructure.list;

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

        public int getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

    }

    /**
     * 反转函数- 迭代算法
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

    public static ListNode recursion(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode newList = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newList;
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        // 反转函数 -- 迭代算法
        /*ListNode iterate = iterate(node1);

        while (iterate != null) {
            System.out.print(iterate.getVal() + " -> ");
            iterate = iterate.getNext();
        }*/

        // 反转函数 -- 递归算法
        ListNode recursion = recursion(node1);
        while (recursion != null) {
            System.out.print(recursion.getVal() + " -> ");
            recursion = recursion.getNext();
        }

        System.out.print("null");
    }
}


