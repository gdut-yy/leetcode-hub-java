import java.util.ArrayDeque;
import java.util.Queue;

public class Solution919 {
    static class CBTInserter {
        private final Queue<TreeNode> queue;
        private final TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new ArrayDeque<>();
            queue.add(root);
            while (queue.element().left != null && queue.element().right != null) {
                TreeNode node = queue.remove();
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        public int insert(int v) {
            TreeNode parent = queue.element();
            TreeNode node = new TreeNode(v);
            if (parent.left == null) {
                parent.left = node;
            } else {
                parent.right = node;
                queue.remove();
                queue.add(parent.left);
                queue.add(parent.right);
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
/*
919. 完全二叉树插入器
https://leetcode.cn/problems/complete-binary-tree-inserter/

第 105 场周赛 T3。

完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
- CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
- CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
- CBTInserter.get_root() 将返回树的头节点。

队列
 */