package com.github.algorithm.reversenode;

import com.github.algorithm.util.ListNode;
import sun.tools.tree.AssignShiftRightExpression;

/**
 * @Author: zlzhang0122
 * @Date: 2022/6/15 下午5:16
 */
public class ListNodeReverseK {
    private static ListNode temp = null;

    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        System.out.println(listNode1);

        ListNode res1 = reverseNodeK(listNode1, 3);
        System.out.println(res1);
    }

    private static ListNode reverseNodeK(ListNode head, int k){
        if (head == null) return null;
        ListNode left, right;
        left = right = head;
        for(int i = 0; i < k; i++) {
            if(right == null) return head;
            right = right.next;
        }
        ListNode newHead = reverse(left, right);
        left.next = reverseNodeK(right, k);
        return newHead;
    }

    private static ListNode reverse(ListNode left, ListNode right) {
        ListNode pre = null, cur = left, next = left;
        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
