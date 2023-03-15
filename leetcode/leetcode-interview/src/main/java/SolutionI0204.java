import java.util.ArrayList;
import java.util.List;

public class SolutionI0204 {
    public ListNode partition(ListNode head, int x) {
        // 分左右
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        while (head != null) {
            if (head.val < x) {
                leftList.add(head.val);
            } else {
                rightList.add(head.val);
            }
            head = head.next;
        }

        // 合并
        leftList.addAll(rightList);

        // List => ListNode
        ListNode dummy = new ListNode(-1);
        ListNode h0 = dummy;
        for (int num : leftList) {
            h0.next = new ListNode(num);
            h0 = h0.next;
        }
        return dummy.next;
    }
}
/*
面试题 02.04. 分割链表
https://leetcode.cn/problems/partition-list-lcci/

给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
你不需要 保留 每个分区中各节点的初始相对位置。
提示：
链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200

同: 86. 分隔链表
https://leetcode.cn/problems/partition-list/
 */