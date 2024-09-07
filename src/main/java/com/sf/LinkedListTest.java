package com.sf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedListTest {

    // lc92: 链表反转
    // 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
    // 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
       // 1、 切割链表
        ListNode pre = dummy;
        for (int i = 0; i < left -1; i++) {
            pre = pre.next;
        }

        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 2、反转中间部分链表
        ListNode leftNode = pre.next;
        ListNode p = rightNode.next;

        pre.next = null;
        rightNode.next = null;

        reverse(leftNode);

        // 3、重新拼接链表
        pre.next = rightNode;
        leftNode.next = p;
        return dummy.next;
    }

    //  lc 206 链表反转
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // lc138: 链表复制，深度copy
    public ListNode copyRandomList(ListNode head) {
        // hashtable 存储
        HashMap<ListNode, ListNode> old2new = new HashMap<>();
        // 遍历创建节点
        ListNode cur = head;
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            old2new.put(cur, newNode);
            cur = cur.next;
        }

        // 第二次遍历，设置next和random
        cur = head;
        while (cur != null) {
            ListNode curNew = old2new.get(cur);
            if (old2new.get(cur.next) != null) {
                curNew.next = old2new.get(cur.next);
            }
            //
            if (old2new.get(cur.random) != null) {
                curNew.random = old2new.get(cur.random);
            }
            cur = cur.next;
        }
        return old2new.get(head);
    }

    // lc 21: 合并有序链表
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null && list2 == null) {
            cur.next = list1;
        }
        if (list2 != null && list1 == null) {
            cur.next = list2;
        }
        return head.next;
    }

     // lc2:链表节点数加和： 核心点：链表高位补0和进位处理
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         ListNode head = null;
         ListNode cur = null;
         int carry = 0;
         while(l1 != null || l2 != null) {
             int n1= l1 == null ? 0 : l1.val;
             int n2= l2 == null ? 0: l2.val;
             int sum = n1 + n2 + carry;
             int lowData = sum % 10;
             if (head == null) {
                 head = cur = new ListNode(lowData);
             } else {
                 cur.next = new ListNode(lowData);
                 cur = cur.next;
             }
             carry = sum / 10;
             if (l1 != null) {
                 l1 = l1.next;
             }
             if (l2 != null) {
                 l2 = l2.next;
             }
         }
         if (carry > 0) {
             cur.next = new ListNode(carry);
         }
         return head;
     }

    // lc141:
    public boolean hasCycle(ListNode head) {
        // 当前算法的最坏情况，空间复杂度为o(n), 更优的算法可以使用快慢指针遍历，如果慢指针追上快指针，则存在环
        Set<ListNode> seenSet = new HashSet<>();
        ListNode cur = head;
        while(cur!= null) {
            if (!seenSet.add(cur)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

     // lc83:单链表去重，重复元素保留一个
     public ListNode deleteDuplicates1(ListNode head) {
         if (head == null) {
             return head;
         }
         ListNode cur = head;
         while (cur.next != null) {
             if (cur.val != cur.next.val) {
                 cur = cur.next;
             } else {
                 cur.next = cur.next.next;
             }
         }
         return head;
     }

    // lc: 82 单链表去重(删除重复过，重复的均删除)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode tmp = new ListNode(0, head);
        ListNode cur = tmp;
        while(cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while(cur.next != null && x == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return tmp.next;
    }
}
