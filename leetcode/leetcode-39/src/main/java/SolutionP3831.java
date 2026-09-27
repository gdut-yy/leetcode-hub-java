import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionP3831 {
    public int levelMedian(TreeNode root, int level) {
        // 当前层节点
        List<TreeNode> pre = new ArrayList<>(Collections.singletonList(root));
        List<TreeNode> nxt = new ArrayList<>();
        for (int i = 0; !pre.isEmpty() && i < level; i++) {
            nxt.clear();
            for (TreeNode x : pre) {
                for (TreeNode y : Arrays.asList(x.left, x.right)) {
                    if (y != null) {
                        nxt.add(y);
                    }
                }
            }
            // 交换 pre 与 nxt
            List<TreeNode> tmp = pre;
            pre = nxt;
            nxt = tmp;
        }
        if (pre.isEmpty()) {
            return -1;
        }
        return pre.get(pre.size() / 2).val;
    }
}
/*
$3831. 二叉搜索树某一层的中位数
https://leetcode.cn/problems/median-of-a-binary-search-tree-level/description/

给定一棵 二叉搜索树（BST）的根结点 root 和一个整数 level。
根节点位于第 0 层。每一层代表与根节点的距离。
返回给定 level 中所有节点值的中位数。如果该层不存在或没有节点，则返回 -1。
中位数 定义为将该层的值按 非降序 排序后中间的元素。如果该层的值的数量为偶数，则返回 向上 中位数（排序后两个中间元素中较大的那个）。
示例 1：
输入：root = [4,null,5,null,7], level = 2
输出：7
示例 2：
输入：root = [6,3,8], level = 1
输出：8
示例 3：
输入：root = [2,1], level = 2
输出：-1
提示：
树中节点的数量在 [1, 2 * 10^5] 范围内。
1 <= Node.val <= 10^6
0 <= level <= 2 * 10^5
 */