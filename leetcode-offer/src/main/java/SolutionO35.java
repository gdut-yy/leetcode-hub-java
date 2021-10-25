import java.util.HashMap;
import java.util.Map;

public class SolutionO35 {
    Map<Node, Node> hashMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!hashMap.containsKey(head)) {
            Node copyHead = new Node(head.val);
            hashMap.put(head, copyHead);
            copyHead.next = copyRandomList(head.next);
            copyHead.random = copyRandomList(head.random);
        }
        return hashMap.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
/*
剑指 Offer 35. 复杂链表的复制
https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。

同: 138. 复制带随机指针的链表
https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */