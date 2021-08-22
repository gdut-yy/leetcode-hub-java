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
}
/*
83. 删除排序链表中的重复元素
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/

双指针。第 27 题的指针版。
 */