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

经典题。链表合并。
 */