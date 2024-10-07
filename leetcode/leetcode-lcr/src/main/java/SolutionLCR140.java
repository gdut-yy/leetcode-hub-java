public class SolutionLCR140 {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < cnt; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
/*
LCR 140. 训练计划 II
https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/description/

给定一个头节点为 head 的链表用于记录一系列核心肌群训练项目编号，请查找并返回倒数第 cnt 个训练项目编号。
提示：
1 <= head.length <= 100
0 <= head[i] <= 100
1 <= cnt <= head.length

相似题目: 19. 删除链表的倒数第 N 个结点
https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 */