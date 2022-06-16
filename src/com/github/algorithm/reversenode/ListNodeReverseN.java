package com.github.algorithm.reversenode;

import com.github.algorithm.util.ListNode;

/**
 * @Author: zlzhang0122
 * @Date: 2022/6/15 下午5:16
 */
public class ListNodeReverseN {
    private static ListNode temp = null;

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

//        ListNode res = reverseNode(listNode1);
//        System.out.println(res);

//        ListNode res1 = reverseNodeN(listNode1, 2);
//        System.out.println(res1);

        ListNode res1 = reverseNodeGroup(listNode1, 1, 3);
        System.out.println(res1);
    }

    private static ListNode reverseNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseNode(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }

    private static ListNode reverseNodeN(ListNode head, int n){
        if (n== 1){
            temp = head.next;
            return head;
        }

        ListNode next = reverseNodeN(head.next, n - 1);
        head.next.next = head;
        head.next = temp;
        return next;
    }

    private static ListNode reverseNodeGroup(ListNode head, int m, int k){
        if (m == 1){
            ListNode res = reverseNodeN(head, k);
            return res;
        }
        head.next = reverseNodeGroup(head.next, m - 1, k - 1);
        return head;
    }
}
