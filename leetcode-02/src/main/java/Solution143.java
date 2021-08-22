public class Solution143 {
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next.next;
            }
        }
        ListNode tmp = slow.next;
        slow.next = null;
        link(head, solution206reverseList(tmp), dummy);
    }

    private void link(ListNode l1, ListNode l2, ListNode head) {
        ListNode prev = head;
        while (l1 != null && l2 != null) {
            ListNode tmp = l1.next;

            prev.next = l1;
            l1.next = l2;
            prev = l2;

            l1 = tmp;
            l2 = l2.next;
        }
        if (l1 != null) {
            prev.next = l1;
        }
    }

    public ListNode solution206reverseList(ListNode head) {
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
143. 重排链表
https://leetcode-cn.com/problems/reorder-list/

Step1: 找链表的中间结点。第 876 题 https://leetcode-cn.com/problems/middle-of-the-linked-list/
Step2: 反转链表。第 206 题 https://leetcode-cn.com/problems/reverse-linked-list/
Step3: 连接链表。
 */