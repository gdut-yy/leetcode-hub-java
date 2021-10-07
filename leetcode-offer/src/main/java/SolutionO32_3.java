import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionO32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) {
            return resList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean revert = false;
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
            if (revert) {
                Collections.reverse(curLevelList);
            }
            revert = !revert;
            resList.add(curLevelList);
        }
        return resList;
    }
}
/*
剑指 Offer 32 - III. 从上到下打印二叉树 III
https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/

请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
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
  [20,9],
  [15,7]
]
 */