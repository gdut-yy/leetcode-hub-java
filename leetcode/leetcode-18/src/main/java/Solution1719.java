import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1719 {
    public int checkWays(int[][] pairs) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] p : pairs) {
            adj.computeIfAbsent(p[0], e -> new HashSet<>()).add(p[1]);
            adj.computeIfAbsent(p[1], e -> new HashSet<>()).add(p[0]);
        }
        // 检测是否存在根节点
        int root = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()) {
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();

            if (neighbours.size() == adj.size() - 1) {
                root = node;
            }
        }
        if (root == -1) return 0;

        int ans = 1;
        for (Map.Entry<Integer, Set<Integer>> entry : adj.entrySet()) {
            int node = entry.getKey();
            Set<Integer> neighbours = entry.getValue();

            if (node == root) continue;
            int currDegree = neighbours.size();
            int parent = -1;
            int parentDegree = Integer.MAX_VALUE;

            // 根据 degree 的大小找到 node 的父节点 parent
            for (int neighbour : neighbours) {
                if (adj.get(neighbour).size() < parentDegree && adj.get(neighbour).size() >= currDegree) {
                    parent = neighbour;
                    parentDegree = adj.get(neighbour).size();
                }
            }
            if (parent == -1) return 0;

            // 检测 neighbours 是否是 adj[parent] 的子集
            for (int neighbour : neighbours) {
                if (neighbour == parent) {
                    continue;
                }
                if (!adj.get(parent).contains(neighbour)) {
                    return 0;
                }
            }
            if (parentDegree == currDegree) {
                ans = 2;
            }
        }
        return ans;
    }
}
/*
1719. 重构一棵树的方案数
https://leetcode.cn/problems/number-of-ways-to-reconstruct-a-tree/description/

给你一个数组 pairs ，其中 pairs[i] = [xi, yi] ，并且满足：
- pairs 中没有重复元素
- xi < yi
令 ways 为满足下面条件的有根树的方案数：
- 树所包含的所有节点值都在 pairs 中。
- 一个数对 [xi, yi] 出现在 pairs 中 当且仅当 xi 是 yi 的祖先或者 yi 是 xi 的祖先。
- 注意：构造出来的树不一定是二叉树。
两棵树被视为不同的方案当存在至少一个节点在两棵树中有不同的父节点。
请你返回：
- 如果 ways == 0 ，返回 0 。
- 如果 ways == 1 ，返回 1 。
- 如果 ways > 1 ，返回 2 。
一棵 有根树 指的是只有一个根节点的树，所有边都是从根往外的方向。
我们称从根到一个节点路径上的任意一个节点（除去节点本身）都是该节点的 祖先 。根节点没有祖先。
提示：
1 <= pairs.length <= 10^5
1 <= xi < yi <= 500
pairs 中的元素互不相同。

@zerotrac：这道题的难点在于，它是力扣周赛史上思维难度最大的题目，比赛中只有 16 个人做出来。我的大数据估计分数在 3000 分以上，即竞赛分在 2600 分以下的不要指望在一个半小时之内解决了。竞赛分不超过 2200 分的建议这道题直接收藏然后 cv。
 */