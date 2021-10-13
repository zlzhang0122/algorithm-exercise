package com.github.algorithm.reversenode;

import com.github.algorithm.util.ListNode;

/**
 * 单链表反转
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/6 4:56 PM
 */
public class ListNodeReverse {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        System.out.println(listNode1);

        ListNode listNodeOne = reverseWithoutRecursion(listNode1);
        System.out.println(listNodeOne);

        ListNode listNodeTwo = reverseWithRecursion(listNodeOne);
        System.out.println(listNodeTwo);

        ListNode listNodeThree = reverseWithoutRecursion2(listNodeTwo);
        System.out.println(listNodeThree);
    }

    private static ListNode reverseWithoutRecursion(ListNode head){
        ListNode pre = null, cur = head, next = head;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     *
     * 不妨拿出四本书，摞成一摞（自上而下为 A B C D），要让这四本书的位置完全颠倒过来（即自上而下为 D C B A）：
     *
     * 盯住书A，每次操作把A下面的那本书放到最上面
     *
     * 初始位置：自上而下为 A B C B
     *
     * 第一次操作后：自上而下为 B A C D
     *
     * 第二次操作后：自上而下为 C B A D
     *
     * 第三次操作后：自上而下为 D C B A
     *
     * @param head
     * @return
     */
    private static ListNode reverseWithoutRecursion2(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, cur = head;
        while(cur != null && cur.next != null){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return dummy.next;
    }

    private static ListNode reverseWithRecursion(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nodeNext = reverseWithRecursion(head.next);
        head.next.next = head;
        head.next = null;

        return nodeNext;
    }
}
