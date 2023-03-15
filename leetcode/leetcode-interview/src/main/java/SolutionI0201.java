import java.util.HashSet;
import java.util.Set;

public class SolutionI0201 {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        Set<Integer> hashSet = new HashSet<>();
        // 双指针
        ListNode left = head;
        ListNode right = head;
        hashSet.add(right.val);
        right = right.next;
        while (right != null) {
            if (!hashSet.contains(right.val)) {
                hashSet.add(right.val);
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }
}
/*
面试题 02.01. 移除重复节点
https://leetcode.cn/problems/remove-duplicate-node-lcci/

编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
输入：[1, 2, 3, 3, 2, 1]
输出：[1, 2, 3]

HashSet 判断是否重复。
相似题目: 83. 删除排序链表中的重复元素
https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
注意重复元素定义的区别。
 */