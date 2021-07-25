public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                return true;
            }
        }
        return false;
    }
}
/*
141. 环形链表
https://leetcode-cn.com/problems/linked-list-cycle/

给定一个链表，判断链表中是否有环。
双指针-快慢指针。快慢指针判断链表是否有环
 */