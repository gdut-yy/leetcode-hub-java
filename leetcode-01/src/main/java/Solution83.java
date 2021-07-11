import java.util.Objects;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode left = head;
        ListNode right = head;
        while (right != null) {
            if (left.val != right.val) {
                // nums[left] = nums[right]
                left.next = right;
                // left++
                left = left.next;
            }
            // right++
            right = right.next;
        }
        left.next = null;
        // 注意是返回头节点
        return head;
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
83. 删除排序链表中的重复元素
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

双指针。快慢指针。27 题的指针版。
 */