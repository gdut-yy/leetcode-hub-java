import java.util.Objects;

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

        // junit
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val;
        }

        // junit
        @Override
        public int hashCode() {
            return Objects.hash(val);
        }
    }
}
/*
21. 合并两个有序链表
https://leetcode-cn.com/problems/merge-two-sorted-lists/

经典题。链表合并。
 */