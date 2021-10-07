import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionO32_2 {
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
剑指 Offer 32 - II. 从上到下打印二叉树 II
https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/

从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]

同: 102. 二叉树的层序遍历
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */