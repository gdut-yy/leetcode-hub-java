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
https://leetcode.cn/problems/binary-tree-right-side-view/

给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
提示:
二叉树的节点个数的范围是 [0,100]
-100 <= Node.val <= 100

二叉树“按层”。两个队列实现二叉树广搜
相似题目: 513. 找树左下角的值
https://leetcode.cn/problems/find-bottom-left-tree-value/
515. 在每个树行中找最大值
https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 */