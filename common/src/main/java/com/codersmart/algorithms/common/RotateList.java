package com.codersmart.algorithms.common;

import autovalue.shaded.com.google$.escapevelocity.$EvaluationException;

public class RotateList {
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = new RotateList().rotateRight(head, 2);
        while(result != null){
            System.out.print("" + result.val + " ");
            result = result.next;
        }

    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int count = getTotal(head);
        k = k % count;
        if(k == 0) return head;

        ListNode iter = head;
        ListNode newHead = null, newTail = null, oldTail = null;
        int counter = 0;
        while(iter != null){
            counter ++;
            if(counter == count) oldTail = iter;
            if(counter == count -k + 1) newHead = iter;
            if(counter == count -k ) newTail = iter;
            iter = iter.next;
        }
        oldTail.next = head;
        newTail.next = null;
        head = newHead;
        return head;

    }
    private int getTotal(ListNode head) {
        int count = 0;
        if(head != null) count++;
        while(head.next != null){
            count ++;
            head = head.next;
        }
        return count;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
