public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        // 上文已保证 right != null
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return head;
    }
}
/*
19. 删除链表的倒数第 N 个结点
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/

让快指针先走 n 步，然后快慢指针同速前进
 */