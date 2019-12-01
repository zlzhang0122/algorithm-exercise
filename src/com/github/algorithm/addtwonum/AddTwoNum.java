package com.github.algorithm.addtwonum;

import com.github.algorithm.util.ListNode;

/**
 * @Author: zlzhang0122
 * @Date: 2019/12/1 9:44 PM
 */
public class AddTwoNum {
    public static void main(String[] args){
        AddTwoNum addTwoNum = new AddTwoNum();
        ListNode i1 = new ListNode(2);
        ListNode i2 = new ListNode(4);
        ListNode i3 = new ListNode(3);
        i1.next = i2;
        i2.next = i3;
        i3.next = null;
        ListNode j1 = new ListNode(5);
        ListNode j2 = new ListNode(6);
        ListNode j3 = new ListNode(4);
        j1.next = j2;
        j2.next = j3;
        j3.next = null;

        ListNode listNode = addTwoNum.addTwoNumbers(i1, j1);
        while(listNode != null){
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null, head = null;
        int add = 0, res = 0;
        while(l1 != null && l2 != null){
            res = l1.val + l2.val + add;
            if(res > 9){
                res = res % 10;
                add = 1;
            }else{
                add = 0;
            }
            ListNode item = new ListNode(res);
            if(head == null){
                head = item;
                listNode = item;
            }else{
                listNode.next = item;
                listNode = listNode.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            res = l1.val + add;
            if(res > 9){
                res = res % 10;
                add = 1;
            }else{
                add = 0;
            }
            ListNode item = new ListNode(res);
            if(head == null){
                head = item;
                listNode = item;
            }else{
                listNode.next = item;
                listNode = listNode.next;
            }

            l1 = l1.next;
        }
        while(l2 != null){
            res = l2.val + add;
            if(res > 9){
                res = res % 10;
                add = 1;
            }else{
                add = 0;
            }
            ListNode item = new ListNode(res);
            if(head == null){
                head = item;
                listNode = item;
            }else{
                listNode.next = item;
                listNode = listNode.next;
            }

            l2 = l2.next;
        }
        if(add != 0){
            ListNode item = new ListNode(add);
            if(head == null){
                head = item;
            }else{
                listNode.next = item;
            }
        }

        return head;
    }
}
