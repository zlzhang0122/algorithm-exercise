package com.github.algorithm;

import com.github.algorithm.util.ListNode;

/**
 * @Author: zlzhang0122
 * @Date: 2021/9/23 下午8:21
 */
public class linkrevert {

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode temp = head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("-----------");

        ListNode temp1 = head;
        ListNode newTemp = revert1(temp1);

        while(newTemp != null){
            System.out.println(newTemp.val);
            newTemp = newTemp.next;
        }
    }

    public ListNode revertNode(ListNode head, int k){
        if(k < 2 || head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;

        ListNode ps = head, temp = ps;
        ps = ps.next;
        while (ps != null){
            ListNode first = temp;
            int i = 1;
            temp = ps;
            while (i < k && temp != null){
                i++;
                temp = temp.next;
            }
            if(ps == null){
                break;
            }
        }

        return dummy.next;
    }

    public static ListNode revert2(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy.next;
        ListNode next = cur.next;
        ListNode pre = null;
        while(next != null){
            ListNode pNext = next.next;
            next.next = cur;
            cur.next = pre;
            dummy.next = next;
            pre = cur;
            cur = next;
            next = pNext;
        }

        return dummy.next;
    }

    public static ListNode revert1(ListNode head){
        ListNode pre = null, cur = head, next = null;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
