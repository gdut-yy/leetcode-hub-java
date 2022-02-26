public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode();
        ListNode res = merge;
        while (true) {
            if (l1 == null && l2 == null) {
                return null;
            } else if (l1 == null) {
                merge.val = l2.val;
                merge.next = l2.next;
                break;
            } else if (l2 == null) {
                merge.val = l1.val;
                merge.next = l1.next;
                break;
            }
            if (l1.val < l2.val) {
                merge.val = l1.val;
                l1 = l1.next;
            } else {
                merge.val = l2.val;
                l2 = l2.next;
            }
            merge.next = new ListNode();
            merge = merge.next;
        }
        return res;
    }
}
/*
21. 合并两个有序链表
https://leetcode-cn.com/problems/merge-two-sorted-lists/

将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列

经典题。链表合并。
数组合并可参考第 4 题 https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */