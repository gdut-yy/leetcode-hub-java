public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                break;
            }
        }
        // 为 null 说明链表无环
        if (right == null || right.next == null) {
            return null;
        }
        // 快慢指针相遇时，让慢指针指向头节点，然后快慢指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
        left = head;
        while (left != right) {
            left = left.next;
            right = right.next;
        }
        return left;
    }
}
/*
142. 环形链表 II
https://leetcode-cn.com/problems/linked-list-cycle-ii/

给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回 null。
比 141 题难度升级。要返回入环的第一个节点
双指针-快慢指针。快慢指针相遇时，让慢指针指向头节点，然后快慢指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
 */