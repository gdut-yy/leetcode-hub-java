public class SolutionI0206 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secHalf = slow.next;
        if (fast.next != null) {
            secHalf = slow.next.next;
        }
        slow.next = null;
        return assertListNodeEquals(secHalf, solution206reverseList(head));
    }

    private boolean assertListNodeEquals(ListNode expected, ListNode actual) {
        if (expected == null && actual == null) {
            return true;
        } else if (expected == null || actual == null) {
            return false;
        } else if (expected.val != actual.val) {
            return false;
        } else {
            return assertListNodeEquals(expected.next, actual.next);
        }
    }

    private ListNode solution206reverseList(ListNode head) {
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
面试题 02.06. 回文链表
https://leetcode-cn.com/problems/palindrome-linked-list-lcci/

编写一个函数，检查输入的链表是否是回文的。

同: 234. 回文链表
https://leetcode-cn.com/problems/palindrome-linked-list/
 */