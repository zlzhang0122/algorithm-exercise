package com.github.algorithm.reversenode;

import com.github.algorithm.util.ListNode;

/**
 * 单链表的区间反转
 *
 * @Author: zlzhang0122
 * @Date: 2021/11/6 下午3:23
 */
public class ListNodeReverse2 {
    public static void main(String[] args){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;

        System.out.println(listNode1);

        ListNode listNodeOne = reverse(listNode1, 7, 8);
        System.out.println(listNodeOne);

        ListNode listNodeTwo = reverse(listNode1, 7, 8);
        System.out.println(listNodeTwo);

        ListNode listNodeThree = reverseRecursive(listNodeTwo, 2, 3);
        System.out.println(listNodeThree);
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
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverse(ListNode head, int m, int n){
        if(m >n){
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode preStart = dummy, start = head;
        int i = 0, j = n - m;
        while(i < m){
            preStart = start;
            if(start != null){
                start = start.next;
            }else {
                return dummy.next;
            }

            i++;
        }
        while(j > 0){
            if(start != null){
                ListNode next = start.next;
                if (next != null){
                    start.next = next.next;
                    next.next = preStart.next;
                    preStart.next = next;
                    j--;
                }else {
                    break;
                }
            }else{
                break;
            }
        }
        return dummy.next;
    }

    public static ListNode reverseRecursive(ListNode head, int n, int m){
        int count = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        int j = n;
        while (j < count){
            reverse(head, j, j + m - 1);
            j += m;
        }
        return dummy.next;
    }
}
