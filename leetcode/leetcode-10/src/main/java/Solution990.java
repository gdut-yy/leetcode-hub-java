import java.util.ArrayList;
import java.util.List;

public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        // 小写字母
        UnionFind unionFind = new UnionFind(26);

        List<String> askList = new ArrayList<>();
        for (String equation : equations) {
            int ch1 = equation.charAt(0) - 'a';
            int ch2 = equation.charAt(3) - 'a';
            if (equation.charAt(1) == '=') {
                unionFind.union(ch1, ch2);
            } else {
                askList.add(equation);
            }
        }
        for (String ask : askList) {
            int ch1 = ask.charAt(0) - 'a';
            int ch2 = ask.charAt(3) - 'a';
            if (unionFind.connected(ch1, ch2)) {
                return false;
            }
        }
        return true;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
/*
990. 等式方程的可满足性
https://leetcode.cn/problems/satisfiability-of-equality-equations/

第 123 场周赛 T2。

给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。
在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
提示：
1 <= equations.length <= 500
equations[i].length == 4
equations[i][0] 和 equations[i][3] 是小写字母
equations[i][1] 要么是 '='，要么是 '!'
equations[i][2] 是 '='

并查集。
先将 == 连通。再逐个判断 != 是否满足。
 */