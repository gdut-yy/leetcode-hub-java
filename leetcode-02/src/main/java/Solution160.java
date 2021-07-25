public class Solution160 {
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
160. 相交链表
https://leetcode-cn.com/problems/intersection-of-two-linked-lists/

双指针
如果 pa/pb 不为 null，则 pa/pb 每次往后移一步
如果 pa 为 null 则移到 headB，如果 pb 为 null 则移到 headA
若 pa pb 相交，则 pa 指向节点为相交节点，若 p2 为 null，则两个链表不相交
证明：假设
lenA \
      lenC
lenB /
若相交则 lanA + lenC + lenB
必定等于 lenB + lenC + lenA

时间复杂度 O(m+n)
空间复杂度 O(1)
 */