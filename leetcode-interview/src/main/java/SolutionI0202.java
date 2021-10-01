public class SolutionI0202 {
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        if (fast.next == null) {
            return fast.val;
        }
        // 快指针先走 k 步
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        // 快慢指针同速前进，当 fast.next 为 null 时，返回 slow.val
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }
}
/*
面试题 02.02. 返回倒数第 k 个节点
https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/

实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。

相似题目: 19. 删除链表的倒数第 N 个结点
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */