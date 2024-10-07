import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class SolutionLCR151 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        boolean revert = false;
        while (!q.isEmpty()) {
            List<Integer> curLevelList = new ArrayList<>();
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode o = q.remove();
                curLevelList.add(o.val);
                if (o.left != null) q.add(o.left);
                if (o.right != null) q.add(o.right);
            }
            if (revert) {
                Collections.reverse(curLevelList);
            }
            revert = !revert;
            ans.add(curLevelList);
        }
        return ans;
    }
}
/*
LCR 151. 彩灯装饰记录 III
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/description/

一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照如下规则记录彩灯装饰结果：
- 第一层按照从左到右的顺序记录
- 除第一层外每一层的记录顺序均与上一层相反。即第一层为从左到右，第二层为从右到左。
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

层序遍历。
 */