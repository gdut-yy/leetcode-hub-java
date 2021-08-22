public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
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
双指针-快慢指针。慢指针每次走一步，快指针每次走两步。若两指针相遇，说明链表中有环。
 */