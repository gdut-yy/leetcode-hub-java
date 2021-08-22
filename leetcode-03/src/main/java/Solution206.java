public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
/*
206. 反转链表
https://leetcode-cn.com/problems/reverse-linked-list/

时间复杂度 O(n)
空间复杂度 O(1)
 */