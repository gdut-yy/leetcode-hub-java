import java.util.HashMap;
import java.util.Map;

public class SolutionLCP64 {
    private Map<TreeNode, Map<Integer, Integer>> memo;

    public int closeLampInTree(TreeNode root) {
        memo = new HashMap<>();
        return f(root, 0);
    }

    // f(TreeNode node, boolean switch2Odd, boolean switch3)
    // 表示当前节点，父节点开关 2 切换次数是否是奇数次，父节点开关 3 是否切换时，关闭子树所有灯最少需要操作多少次开关
    // f(node, 0/1, 0/1) => f(node, mask) 方便进行记忆化 mask = switch2Odd << 1 + switch3
    private int f(TreeNode node, int mask) {
        if (node == null) {
            return 0;
        }
        // 记忆化搜索
        if (memo.containsKey(node) && memo.get(node).containsKey(mask)) {
            return memo.get(node).get(mask);
        }

        int res = Integer.MAX_VALUE;
        int bit0 = mask & 1;
        int bit1 = (mask >> 1) & 1;

        // 灯 = 开，且 switch2_odd, switch3 抵消，最终还是开
        // 灯 = 关，且 switch2_odd, switch3 不抵消，最终还是开
        if ((node.val == 1) == (bit1 == bit0)) {
            res = Math.min(res, f(node.left, bit1 << 1) + f(node.right, bit1 << 1) + 1);
            res = Math.min(res, f(node.left, (1 - bit1) << 1) + f(node.right, (1 - bit1) << 1) + 1);
            res = Math.min(res, f(node.left, (bit1 << 1) + 1) + f(node.right, (bit1 << 1) + 1) + 1);
            res = Math.min(res, f(node.left, ((1 - bit1) << 1) + 1) + f(node.right, ((1 - bit1) << 1) + 1) + 3);
        } else {
            res = Math.min(res, f(node.left, bit1 << 1) + f(node.right, bit1 << 1));
            res = Math.min(res, f(node.left, (1 - bit1) << 1) + f(node.right, (1 - bit1) << 1) + 2);
            res = Math.min(res, f(node.left, (bit1 << 1) + 1) + f(node.right, (bit1 << 1) + 1) + 2);
            res = Math.min(res, f(node.left, ((1 - bit1) << 1) + 1) + f(node.right, ((1 - bit1) << 1) + 1) + 2);
        }
        memo.computeIfAbsent(node, key -> new HashMap<>()).put(mask, res);
        return res;
    }
}
/*
LCP 64. 二叉树灯饰
https://leetcode.cn/problems/U7WvvU/

LCCUP'22 力扣杯秋季编程大赛个人赛 T4。

「力扣嘉年华」的中心广场放置了一个巨型的二叉树形状的装饰树。每个节点上均有一盏灯和三个开关。节点值为 0 表示灯处于「关闭」状态，节点值为 1 表示灯处于「开启」状态。每个节点上的三个开关各自功能如下：
- 开关 1：切换当前节点的灯的状态；
- 开关 2：切换 以当前节点为根 的子树中，所有节点上的灯的状态，；
- 开关 3：切换 当前节点及其左右子节点（若存在的话） 上的灯的状态；
给定该装饰的初始状态 root，请返回最少需要操作多少次开关，可以关闭所有节点的灯。
提示：
1 <= 节点个数 <= 10^5
0 <= Node.val <= 1

记忆化搜索
 */