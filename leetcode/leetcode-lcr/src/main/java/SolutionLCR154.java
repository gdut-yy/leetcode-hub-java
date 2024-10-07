import java.util.HashMap;
import java.util.Map;

public class SolutionLCR154 {
    Map<Node, Node> mp = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!mp.containsKey(head)) {
            Node copyHead = new Node(head.val);
            mp.put(head, copyHead);
            copyHead.next = copyRandomList(head.next);
            copyHead.random = copyRandomList(head.random);
        }
        return mp.get(head);
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

        // fastjson
        public int getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public Node getRandom() {
            return random;
        }
    }
}
/*
LCR 154. 复杂链表的复制
https://leetcode.cn/problems/fu-za-lian-biao-de-fu-zhi-lcof/

请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
还有一个 random 指针指向链表中的任意节点或者 null。
提示：
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
节点数目不超过 1000 。

同: 138. 复制带随机指针的链表
https://leetcode.cn/problems/copy-list-with-random-pointer/
 */