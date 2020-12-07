package org.wayne.spring.javase.leetcode;

import com.alibaba.druid.support.json.JSONUtils;

//141. 环形链表
//给定一个链表，判断链表中是否有环。
public class RingListNode {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        int pose = -1;
        ListNode p1 = head;
        ListNode p2 = head;

        while (p1 != null && p2 !=null) {
            if (p2.next == null) {
                return false;
            }
            if (p1.next == p2.next.next) {
                pose = 1;
                return true;
            }
            p1 = p1.next;

            p2 = p2.next.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        n2.next = n1;
        RingListNode ringListNode = new RingListNode();
        System.out.println(ringListNode.hasCycle(n2));
    }


}
