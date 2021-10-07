import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            int curLevelSize = queue.size();
            while (curLevelSize > 0) {
                TreeNode curNode = queue.remove();
                curLevelList.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                curLevelSize--;
            }
            resList.add(curLevelList);
        }
        return resList;
    }
}
/*
102. 二叉树的层序遍历
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/

你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例：
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其层序遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
 */