package com.github.algorithm.mergetwolists;

import com.github.algorithm.util.ListNode;

/**
 * 合并两个有序链表
 *
 * @Author: zlzhang0122
 * @Date: 2020/3/1 10:35 AM
 */
public class MergeTwoLists {
    public static void main(String[] args){
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode14 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode14;

        ListNode listNode21 = new ListNode(1);
        ListNode listNode23 = new ListNode(3);
        ListNode listNode24 = new ListNode(4);
        listNode21.next  = listNode23;
        listNode23.next = listNode24;

        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        ListNode res = mergeTwoLists.merge(listNode11, listNode21);
        System.out.println(res.toString());
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(-1), cur = head;

        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                ListNode item = new ListNode(l1.val);
                cur.next = item;
                cur = cur.next;
                l1 = l1.next;
            }else{
                ListNode item = new ListNode(l2.val);
                cur.next = item;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        while (l1 != null){
            ListNode item = new ListNode(l1.val);
            cur.next = item;
            cur = cur.next;
            l1 = l1.next;
        }
        while (l2 != null){
            ListNode item = new ListNode(l2.val);
            cur.next = item;
            cur = cur.next;
            l2 = l2.next;
        }

        return head.next;
    }
}
