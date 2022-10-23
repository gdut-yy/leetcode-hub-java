public class Hhrc220925T4 {
    private int res = 0;

    public int minSupplyStationNumber(TreeNode root) {
        if (dfs(root) == 0) {
            return res + 1;
        }
        return res;
    }

    // 0：该节点无覆盖
    // 1：本节点有摄像头
    // 2：本节点有覆盖
    private int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        if (left == 1 || right == 1) {
            return 2;
        }
        return 0;
    }
}
/*
题目-04. 补给覆盖
https://leetcode.cn/contest/hhrc2022/problems/wFtovi/

已知有一片呈二叉树的道路，我们要在道路上的一些节点设置补给站支援。
补给站可以设置在任意节点上，每个补给站可以使距离自身小于等于 1 个单位的节点获得补给。
若要使道路的所有节点均能获得补给，请返回所需设置的补给站最少数量。
示例 1：
输入：[0,0,0]
输出：1
解释：如图所示，一个补给站足够使道路的所有节点获得补给。
示例 2：
输入：[0,0,0,null,null,null,0]
输出：2
解释：需要至少设置两个补给站来使道路的所有节点获得补给。 上图显示了补给站设置的有效位置之一。
提示：
节点的数量范围为 [1, 1000]。
每个节点的值均为 0 。

相似题目: 968. 监控二叉树
https://leetcode.cn/problems/binary-tree-cameras/
 */