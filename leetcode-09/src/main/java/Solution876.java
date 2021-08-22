public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        return slow;
    }
}
/*
876. 链表的中间结点
https://leetcode-cn.com/problems/middle-of-the-linked-list/

第 95 场周赛 T1。
双指针-快慢指针。当快指针以两倍步长走完时，慢指针刚好到达中点。
 */