import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionLCR150 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode o = q.remove();
                curLevelList.add(o.val);
                if (o.left != null) q.add(o.left);
                if (o.right != null) q.add(o.right);
            }
            ans.add(curLevelList);
        }
        return ans;
    }
}
/*
LCR 150. 彩灯装饰记录 II
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/description/

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
https://leetcode.cn/problems/binary-tree-level-order-traversal/
 */