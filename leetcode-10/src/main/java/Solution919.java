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
https://leetcode-cn.com/problems/complete-binary-tree-inserter/

队列
 */