package com.codersmart.algorithms.common;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        c.next = new ListNode(6);
        ListNode listNode = new MergeKSortedLists().mergeKLists(new ListNode[]{a, b, c});
        while(listNode != null){
            System.out.print(" " + listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);

        for(ListNode node : lists){
            if(node != null) {
                pq.add(node);
            }
        }
        ListNode head = pq.poll();
        ListNode pre = head;
        while(pq.size() > 0){
            if(pre.next != null){
                pq.add(pre.next);
            }
            pre.next = pq.poll();
            pre = pre.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
