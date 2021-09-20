public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
/*
92. 反转链表 II
https://leetcode-cn.com/problems/reverse-linked-list-ii/

第 206 题反转链表 https://leetcode-cn.com/problems/reverse-linked-list/ 升级版

一次遍历「穿针引线」反转链表（头插法）

       9,7,[2,5,4,3,]6
step1: 9,7,[5,2,4,3,]6
step2: 9,7,[4,5,2,3,]6
step3: 9,7,[3,4,5,2,]6

时间复杂度 O(n)
空间复杂度 O(1)
 */
