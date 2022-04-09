package com.solutions.examples;

/**
 *
 * tips: 使用三个临时节点
 *
 * <pre>{@code
 * //Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * }
 * </pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-linked-list/submissions/">206. 反转链表</a>
 * @see <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 *
 */

public class Solution206 {

    public ListNode reverseList(ListNode head) {
        ListNode first = head;
        ListNode second = null;
        ListNode third = null;
        if (head != null && head.next != null) {
            second = head.next;
            head.next = null;
            if (second.next != null) {
                third = second.next;
            }
        }

        while(third != null) {
            second.next = first;
            first = second;
            second = third;
            third = third.next;
        }

        if (second != null) {
            second.next = first;
            first = second;
        }

        return first;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
