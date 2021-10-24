public class SolutionO36 {
    private Node pre;
    private Node head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        // 中序遍历
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;

        inorder(root.right);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
/*
剑指 Offer 36. 二叉搜索树与双向链表
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/

输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向

只有题目描述的用例，详见题面。
 */