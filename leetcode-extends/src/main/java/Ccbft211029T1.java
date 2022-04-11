public class Ccbft211029T1 {
    public ListNode deleteListNode(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        boolean isOdd = true;
        head = dummy;
        while (head.next != null) {
            isOdd = !isOdd;
            if (isOdd) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
/*
建信01. 间隔删除链表结点
https://leetcode-cn.com/contest/ccbft-2021fall/problems/woGGnF/

给你一个链表的头结点 head，每隔一个结点删除另一个结点（要求保留头结点）。
请返回最终链表的头结点。

示例 1：
输入：head = [1,2,3,4]
输出: [1,3]

示例 2：
输入：head = [5,1,8,6,1]
输出: [5,8,1]

提示：
链表中结点的数目在[1, 5000]范围内。
1 <= Node.val <= 10000
 */