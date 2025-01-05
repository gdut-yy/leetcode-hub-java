import java.util.HashMap;
import java.util.Map;

public class Solution1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        Map<Integer, ListNode> mp = new HashMap<>();
        int ps = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            ps += node.val;
            mp.put(ps, node); // 相同前缀和的直接覆盖
        }

        ps = 0;
        for (ListNode node = dummy; node != null; node = node.next) {
            ps += node.val;
            node.next = mp.get(ps).next;
        }
        return dummy.next;
    }
}
/*
1171. 从链表中删去总和值为零的连续节点
https://leetcode.cn/problems/remove-zero-sum-consecutive-nodes-from-linked-list/description/

给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
删除完毕后，请你返回最终结果链表的头节点。
提示：
给你的链表中可能有 1 到 1000 个节点。
对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000.

哈希表。
 */