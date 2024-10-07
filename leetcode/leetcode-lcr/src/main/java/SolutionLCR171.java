public class SolutionLCR171 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 双指针
        ListNode pa = headA;
        ListNode pb = headB;
        while (pa != pb) {
            if (pa == null) {
                pa = headB;
            } else {
                pa = pa.next;
            }
            if (pb == null) {
                pb = headA;
            } else {
                pb = pb.next;
            }
        }
        return pa;
    }
}
/*
LCR 171. 训练计划 V
https://leetcode.cn/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

某教练同时带教两位学员，分别以链表 l1、l2 记录了两套核心肌群训练计划，节点值为训练项目编号。两套计划仅有前半部分热身项目不同，后续正式训练项目相同。请设计一个程序找出并返回第一个正式训练项目编号。如果两个链表不存在相交节点，返回 null 。
注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

同: 160. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/
面试题 02.07. 链表相交
https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/
 */