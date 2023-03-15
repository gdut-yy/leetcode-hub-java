public class SolutionO18 {
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
剑指 Offer 18. 删除链表的节点
https://leetcode.cn/problems/shan-chu-lian-biao-de-jie-dian-lcof/

给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
返回删除后的链表的头节点。

输入: head = [4,5,1,9], val = 5
输出: [4,1,9]
 */