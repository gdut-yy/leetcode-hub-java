public class Solution430 {
    public Node flatten(Node head) {
        flattenGetTail(head);
        return head;
    }

    private Node flattenGetTail(Node head) {
        Node node = head;
        Node tail = null;
        while (node != null) {
            Node next = node.next;
            if (node.child != null) {
                Node child = node.child;
                Node childTail = flattenGetTail(node.child);

                node.child = null;
                node.next = child;
                child.prev = node;
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                tail = childTail;
            } else {
                tail = node;
            }
            node = next;
        }
        return tail;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }
}
/*
430. 扁平化多级双向链表
https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/

双向链表和循环链表。
 */