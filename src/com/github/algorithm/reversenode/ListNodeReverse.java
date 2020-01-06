package com.github.algorithm.reversenode;

import com.github.algorithm.util.ListNode;

/**
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

//        ListNode listNodeOne = reverseWithoutLoop(listNode1);
//        System.out.println(listNodeOne);

        ListNode listNodeTwo = reverseWithLoop(listNode1);
        System.out.println(listNodeTwo);
    }

    private static ListNode reverseWithoutLoop(ListNode head){
        ListNode pre = head, cur = head.next, tmp;
        pre.next = null;
        while(cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        return pre;
    }

    private static ListNode reverseWithLoop(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode nodeNext = reverseWithLoop(head.next);
        head.next.next = head;
        head.next = null;

        return nodeNext;
    }
}
