package com.github.algorithm.noderemove;

import com.github.algorithm.util.ListNode;

/**
 * 移除链表的倒数第n个几点
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/7 10:04 PM
 */
public class NodeNRemove {
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

        ListNode newList = removeNThNode(listNode1, 2);

        System.out.println(newList);
    }

    private static ListNode removeNThNode(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy;
        for(int i = 0; i < n; i++){
            pre = pre.next;
        }
        while(pre.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}
