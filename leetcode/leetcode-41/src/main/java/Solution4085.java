public class Solution4085 {
    private static final char[] childColor = new char[128];

    static {
        childColor['R'] = 'B';
        childColor['B'] = 'W';
        childColor['W'] = 'R';
    }

    public int findColoredRoot(int[][] edges, String colors) {
        char[] s = colors.toCharArray();
        int n = s.length;
        int[] inDeg = new int[n];
        int[] outDeg = new int[n];

        for (int[] e : edges) {
            int x = e[0], y = e[1];
            char cx = s[x], cy = s[y];
            if (cx == cy) {
                return -1;
            }
            // 确定谁是谁的父节点
            if (childColor[cx] != cy) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            // x 是 y 的父节点
            outDeg[x]++;
            inDeg[y]++;
            if (outDeg[x] > 2 || inDeg[y] > 1) {
                return -1;
            }
        }
        for (int i = 0; ; i++) {
            if (inDeg[i] == 0) {
                return i;
            }
        }
    }
}
/*
4085. 找到颜色树的根
https://leetcode.cn/problems/find-root-of-a-colored-tree/description/

第 524 场周赛 T3。

给你一棵含有 n 个节点的无向 树，节点编号从 0 到 n - 1，用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 之间存在一条无向边。
同时给你一个长度为 n 的字符串 colors，其中 colors[i] 是 'R'、'B' 或 'W' 之一，表示节点 i 的颜色。
一个被选作 根节点 的节点，在以它为起点将树定向（即从根向外定向）之后，必须同时满足以下两个 条件：
1.二叉树性质：每个节点最多有两个子节点。
2.分层颜色模式：处于相同深度的所有节点都具有相同的颜色。从深度 0 开始，这些颜色遵循以下三种循环序列之一：
  - R → B → W → R → B → W → ...
  - B → W → R → B → W → R → ...
  - W → R → B → W → R → B → ...
返回满足这两个条件的任意根节点的 下标，如果不存在这样的根节点，则返回 -1。
树 是一个无环的连通无向图。
节点的 深度 是从根节点到该节点的路径上的边数。根节点的深度为 0。一个节点的 子节点 是指与其相邻且深度大 1 的节点。
节点的 度 是指与该节点相连的边数。
示例 1：
输入： edges = [[3,1],[3,2],[1,4],[2,0]], colors = "BRRWB"
输出： 3
示例 2：
输入： edges = [[0,1],[1,2],[2,3]], colors = "RBRB"
输出： -1
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] = [ui, vi]
0 <= ui, vi < n
colors.length == n
colors[i] 是 'R'、'B' 或 'W' 之一。
输入图是一棵树，且每个节点的度最多为三。

统计入度出度 + 一次遍历
https://leetcode.cn/problems/find-root-of-a-colored-tree/solutions/4045139/zhi-you-yi-ge-dian-neng-zuo-wei-gen-by-e-d0s5/
 */