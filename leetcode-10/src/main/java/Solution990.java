import java.util.ArrayList;
import java.util.List;

public class Solution990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();
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
            if (unionFind.find(ch1) == unionFind.find(ch2)) {
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

        public UnionFind() {
            // 小写字母
            int len = 26;
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }

        /**
         * 返回节点 x 的根节点
         *
         * @param x 节点 x
         * @return 节点 x 的根节点
         */
        public int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        /**
         * 将 p 和 q 连通
         *
         * @param p p
         * @param q q
         */
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
            }
        }
    }
}
/*
990. 等式方程的可满足性
https://leetcode-cn.com/problems/satisfiability-of-equality-equations/

并查集。
先将 == 连通。再逐个判断 != 是否满足。
 */