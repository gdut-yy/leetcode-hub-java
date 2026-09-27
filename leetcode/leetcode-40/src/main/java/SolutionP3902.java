import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SolutionP3902 {
    public List<Long> zigzagLevelSum(TreeNode root) {
        List<Long> ans = new ArrayList<>();
        int level = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            level++;
            List<TreeNode> levelNodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            long sum = 0;
            int start = level % 2 != 0 ? 0 : size - 1;
            int direction = level % 2 != 0 ? 1 : -1;
            boolean flag = true;
            for (int i = 0, j = start; i < size && flag; i++, j += direction) {
                TreeNode node = levelNodes.get(j);
                if (level % 2 != 0 && node.left != null || level % 2 == 0 && node.right != null) {
                    sum += node.val;
                } else {
                    flag = false;
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
/*
$3902. 二叉树的 Z 字形层级和
https://leetcode.cn/problems/zigzag-level-sum-of-binary-tree/description/

给定一棵 二叉树 的根节点 root。
按 Z 字形模式逐层遍历树：
- 在 奇数 层（下标从 1 开始）中，从左到右 遍历节点。
- 在 偶数 层，从右到左 遍历节点。
在指定方向遍历某一层时，按顺序处理节点，并立即在第一个违反条件的节点前 停止：
- 在 奇数 层：该节点没有 左 子节点。
- 在 偶数 层：该节点没有 右 子节点。
只有在此停止条件之前的节点对层级和有贡献。
返回一个整数数组 ans，其中 ans[i] 是在第 i + 1 层处理的节点值之 和。
示例 1：
输入：root = [5,2,8,1,null,9,6]
输出：[5,8,0]
示例 2：
输入：root = [1,2,3,4,5,null,7]
输出：[1,5,0]
提示：
树中的节点数范围为 [1, 10^5]。
-10^5 <= Node.val <= 10^5
 */