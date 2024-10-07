import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionLCR149 {
    public int[] decorateRecord(TreeNode root) {
        if (root == null) return new int[0];

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode o = q.remove();
            ans.add(o.val);
            if (o.left != null) q.add(o.left);
            if (o.right != null) q.add(o.right);
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }
}
/*
LCR 149. 彩灯装饰记录 I
https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/description/

一棵圣诞树记作根节点为 root 的二叉树，节点值为该位置装饰彩灯的颜色编号。请按照从 左 到 右 的顺序返回每一层彩灯编号。
例如:
给定二叉树: [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回：
[3,9,20,15,7]
提示：
节点总数 <= 1000
 */