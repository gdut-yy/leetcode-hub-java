public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 哑节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (true) {
            ListNode p = cur.next;
            ListNode q = cur;
            for (int i = 0; i < k; i++) {
                if (q.next != null) {
                    q = q.next;
                } else {
                    return dummy.next;
                }
            }
            ListNode qNext = q.next;
            cur.next = reverseList(p, q.next);
            p.next = qNext;
            cur = p;
        }
    }

    public ListNode reverseList(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != end) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
/*
25. K 个一组翻转链表
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/

给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
k 是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
进阶：
你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

0 -> 1 -> 2 -> 3 -> 4 -> 5
     p         q

0 -> 3 -> 2 -> 1 -> 4 -> 5
cur  q         p
                   qNext

相似题目: 24. 两两交换链表中的节点
https://leetcode-cn.com/problems/swap-nodes-in-pairs/
206. 反转链表
https://leetcode-cn.com/problems/reverse-linked-list/
 */