import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue1 = new ArrayDeque<>();
        Queue<TreeNode> queue2 = new ArrayDeque<>();
        queue1.add(root);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.remove();
            if (node.left != null) {
                queue2.add(node.left);
            }
            if (node.right != null) {
                queue2.add(node.right);
            }
            if (queue1.isEmpty()) {
                resList.add(node.val);
                queue1 = queue2;
                queue2 = new ArrayDeque<>();
            }
        }
        return resList;
    }
}
/*
199. 二叉树的右视图
https://leetcode-cn.com/problems/binary-tree-right-side-view/

二叉树“按层”。两个队列实现二叉树广搜
参考第 513、515 题
 */