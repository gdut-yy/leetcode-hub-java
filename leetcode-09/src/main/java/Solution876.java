public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode left = head;
        ListNode right = head;
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
            if (left == right) {
                break;
            }
        }
        return left;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
/*
876. 链表的中间结点
https://leetcode-cn.com/problems/middle-of-the-linked-list/

双指针-快慢指针，当快指针以两倍步长走完时，慢指针刚好到达中点。
 */