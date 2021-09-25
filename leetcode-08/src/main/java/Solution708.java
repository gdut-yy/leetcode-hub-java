public class Solution708 {
    /**
     * 剑指 Offer II 029. 排序的循环链表
     * https://leetcode-cn.com/problems/4ueAj6/
     */
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
        } else if (head.next == head) {
            head.next = node;
            node.next = head;
        } else {
            insertCore(head, node);
        }
        return head;
    }

    private void insertCore(Node head, Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }

        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            node.next = biggest.next;
            biggest.next = node;
        }
    }
}
/*
$708. 循环有序列表的插入
https://leetcode-cn.com/problems/insert-into-a-sorted-circular-linked-list/

双向链表和循环链表。
 */