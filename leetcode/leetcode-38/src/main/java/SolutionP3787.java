import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionP3787 {
    private int n;
    private List<Integer>[] g;
    private StringBuilder res;
    private int[] dis;

    public String findSpecialNodes(int n, int[][] edges) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        res = new StringBuilder();
        for (int i = 0; i < n; i++) {
            res.append('0');
        }
        dis = new int[n];

        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            g[a].add(b);
            g[b].add(a);
        }
        round(round(0));
        return res.toString();
    }

    private void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y != fa) {
                dis[y] = dis[x] + 1;
                dfs(y, x);
            }
        }
    }

    private int round(int x) {
        dis[x] = 0;
        dfs(x, -1);
        int ret = 0;
        int maxi = dis[0];
        for (int i = 1; i < n; i++) {
            if (dis[i] > maxi) {
                maxi = dis[i];
                ret = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (dis[i] == maxi) {
                res.setCharAt(i, '1');
            }
        }
        return ret;
    }
}
/*
$3787. 查找树的直径端点
https://leetcode.cn/problems/find-diameter-endpoints-of-a-tree/description/

给定一棵编号从 0 到 n - 1 的有 n 个节点 无向树。它通过一个长度为 n - 1 的二维整数数组 edges 给出，其中 edges[i] = [ai, bi] 表示树中的 ai 和 bi 节点之间有一条边。
如果一个节点是树的任何 直径路径 的 端点，则称其为 特殊 节点。
返回一个长度为 n 的二进制字符串 s，其中如果节点 i 是特殊的，则 s[i] = '1'，否则 s[i] = '0'。
一棵树的 直径路径 是任意两个节点之间的 最长 简单路径。一棵树可能有多个直径路径。
路径的 端点 是该路径上的 第一个 或 最后一个 节点。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] = [ai, bi]
0 <= ai, bi < n
输入保证 edges 表示一棵合法的树。

https://leetcode.cn/problems/find-diameter-endpoints-of-a-tree/solutions/3864204/dui-zhao-zhi-jing-suan-fa-shao-zuo-xiu-g-88bj/
时间复杂度 O(n)。
 */