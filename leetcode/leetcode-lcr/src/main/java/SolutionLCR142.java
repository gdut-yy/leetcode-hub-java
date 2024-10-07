public class SolutionLCR142 {
    public ListNode trainningPlan(ListNode l1, ListNode l2) {
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
LCR 142. 训练计划 IV
https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/description/

给定两个以 有序链表 形式记录的训练计划 l1、l2，分别记录了两套核心肌群训练项目编号，请合并这两个训练计划，按训练项目编号 升序 记录于链表并返回。
注意：新链表是通过拼接给定的两个链表的所有节点组成的。
提示：
0 <= 链表长度 <= 1000

同: 21. 合并两个有序链表
https://leetcode.cn/problems/merge-two-sorted-lists/
 */