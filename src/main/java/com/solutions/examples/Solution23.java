package com.solutions.examples;

/**

 *
 * tips: 每次将选中的要加入 结果链表 的元素 设为该链表的头元素
 *
 * <pre>{@code
 * // Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * }</pre>
 *
 * @author  <a href="mailto:jackson19910303@gmail.com">Jackson</a>
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">23. 合并K个升序链表</a>
 * @see <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 *
 */
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode minHeadListNode = new ListNode();
        ListNode minTailListNode = minHeadListNode;
        int k = 0;
        while (true) {
            ListNode tmpListNode = null;
            int j=0;
            for (int i=0; i<lists.length; i++) {
                ListNode listnode = lists[i];
                if (listnode != null && (tmpListNode == null || (tmpListNode != null && listnode.val < tmpListNode.val))) {
                    j = i;
                    tmpListNode = listnode;
                }
            }
            if (tmpListNode == null) {
                break;
            }
            lists[j] = lists[j].next;
            minTailListNode.next = tmpListNode;
            minTailListNode = minTailListNode.next;
        }
        return minHeadListNode.next;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
