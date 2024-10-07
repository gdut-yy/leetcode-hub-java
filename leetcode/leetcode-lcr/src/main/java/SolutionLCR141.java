public class SolutionLCR141 {
    public ListNode trainningPlan(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
/*
LCR 141. 训练计划 III
https://leetcode.cn/problems/fan-zhuan-lian-biao-lcof/

给定一个头节点为 head 的单链表用于记录一系列核心肌群训练编号，请将该系列训练编号 倒序 记录于链表并返回。
提示：
链表中节点的数目范围是 [0, 5000]
-5000 <= Node.val <= 5000

同: 206. 反转链表
https://leetcode.cn/problems/reverse-linked-list/
 */