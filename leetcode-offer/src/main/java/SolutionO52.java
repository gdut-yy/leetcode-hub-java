public class SolutionO52 {
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
剑指 Offer 52. 两个链表的第一个公共节点
https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/

输入两个链表，找出它们的第一个公共节点。

同: 160. 相交链表
https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

面试题 02.07. 链表相交
https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */