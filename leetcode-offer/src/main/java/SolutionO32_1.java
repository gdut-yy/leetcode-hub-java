import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionO32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> resList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.remove();
            resList.add(curNode.val);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return resList.stream().mapToInt(i -> i).toArray();
    }
}
/*
剑指 Offer 32 - I. 从上到下打印二叉树
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7

返回：
[3,9,20,15,7]
 */