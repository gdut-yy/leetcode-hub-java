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

存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
返回同样按升序排列的结果链表。

1,1,2
1,2

双指针。第 27 题的指针版。
 */