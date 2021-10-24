import java.util.LinkedList;
import java.util.Queue;

public class SolutionO55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
        }
        return level;
    }
}
/*
剑指 Offer 55 - I. 二叉树的深度
https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/

输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

同: 104. 二叉树的最大深度
https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */