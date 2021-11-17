import java.util.HashMap;
import java.util.Map;

public class Solution138 {
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
138. 复制带随机指针的链表
https://leetcode-cn.com/problems/copy-list-with-random-pointer/

给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
构造这个链表的 深拷贝。

回溯 + HashMap 模拟。
时间复杂度 O(n)
空间复杂度 O(n)
 */