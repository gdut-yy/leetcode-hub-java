public class SolutionLCR136 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curNode = new ListNode(0);
        curNode.next = head;
        head = curNode;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
                break;
            }
            curNode = curNode.next;
        }
        return head.next;
    }
}
/*
LCR 136. 删除链表的节点
https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/description/

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。
说明：
题目保证链表中节点的值互不相同
若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */