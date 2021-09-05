import java.util.ArrayDeque;
import java.util.Queue;

public class Solution513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);
        int bottomLeft = root.val;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.remove();
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
                if (!queue1.isEmpty()) {
                    bottomLeft = queue1.element().val;
                }
            }
        }
        return bottomLeft;
    }
}
/*
513. 找树左下角的值
https://leetcode-cn.com/problems/find-bottom-left-tree-value/

二叉树“按层”。两个队列实现二叉树广搜
参考第 199、515 题
 */