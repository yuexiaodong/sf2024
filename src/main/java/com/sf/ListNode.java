package com.sf;

import java.util.List;

public class ListNode {

    int val;
    ListNode next;
    ListNode random;

    ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode random, ListNode next, int val) {
        this.random = random;
        this.next = next;
        this.val = val;
    }
}
