public class SolutionI0207 {
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
面试题 02.07. 链表相交
https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/

给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

同: 160. 相交链表
https://leetcode.cn/problems/intersection-of-two-linked-lists/
 */