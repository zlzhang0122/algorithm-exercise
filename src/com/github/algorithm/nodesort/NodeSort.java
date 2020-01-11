package com.github.algorithm.nodesort;

import com.github.algorithm.util.ListNode;

/**
 * 单链表排序(插入排序)
 *
 * @Author: zlzhang0122
 * @Date: 2020/1/11 9:09 PM
 */
public class NodeSort {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(listNode1);
        ListNode node = sortNode(listNode1);
        System.out.println(node);
    }

    private static ListNode sortNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head, cur = head.next;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        while(cur != null){
            if(cur.val < pre.val){
                pre.next = cur.next;
                ListNode node1 = dummy, node2 = dummy.next;
                while(cur.val > node2.val){
                    node1 = node2;
                    node2 = node2.next;
                }
                node1.next = cur;
                cur.next = node2;
                cur = pre.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
