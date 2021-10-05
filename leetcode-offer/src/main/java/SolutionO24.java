public class SolutionO24 {
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
剑指 Offer 24. 反转链表
https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/

定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

同: 206. 反转链表
https://leetcode-cn.com/problems/reverse-linked-list/
 */