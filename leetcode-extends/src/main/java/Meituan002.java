import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Meituan002 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        // input
        int n = Integer.parseInt(reader.readLine());
        int[] w = new int[n];
        String[] line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(line[i]);
        }
        int[] order = new int[n];
        line = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(line[i]);
        }

        // solution
        int[] res = solution(n, w, order);

        // output
        for (int x : res) {
            writer.write(String.valueOf(x));
            writer.write(System.lineSeparator());
        }
        writer.close();
        reader.close();
    }

    /**
     * solution
     *
     * @param n     货物的数量
     * @param w     1~n 号货物的重量 w[i]
     * @param order 按顺序取出的货物的编号
     * @return 每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少
     */
    private static int[] solution(int n, int[] w, int[] order) {
        // index统一成从0开始
        for (int i = 0; i < n; i++) {
            order[i]--;
        }
        UnionFind unionFind = new UnionFind(n);
        boolean[] visited = new boolean[n];
        int[] res = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int idx = order[i];
            visited[idx] = true;
            unionFind.count[idx] = w[idx];
            // 左邻居
            if (idx - 1 >= 0 && visited[idx - 1]) {
                unionFind.union(idx - 1, idx);
            }
            // 右邻居
            if (idx + 1 < n && visited[idx + 1]) {
                unionFind.union(idx, idx + 1);
            }
            res[i - 1] = Math.max(res[i], unionFind.getCount(idx));
        }
        return res;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int[] count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
            count = new int[n];
        }

        /**
         * 返回节点 x 的根节点
         *
         * @param x 节点 x
         * @return 节点 x 的根节点
         */
        private int find(int x) {
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
                    count[rootP] += count[rootQ];
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                    count[rootQ] += count[rootP];
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                    count[rootP] += count[rootQ];
                }
            }
        }

        public int getCount(int x) {
            return count[find(x)];
        }
    }
}
/*
meituan-002. 小美的仓库整理
https://leetcode-cn.com/problems/TJZLyC/

小美是美团仓库的管理员，她会根据单据的要求按顺序取出仓库中的货物，每取出一件货物后会把剩余货物重新堆放，使得自己方便查找。
已知货物入库的时候是按顺序堆放在一起的。如果小美取出其中一件货物，则会把货物所在的一堆物品以取出的货物为界分成两堆，
这样可以保证货物局部的顺序不变。

已知货物最初是按 1~n 的顺序堆放的，每件货物的重量为 w[i] ,小美会根据单据依次不放回的取出货物。请问根据上述操作，
小美每取出一件货物之后，重量和最大的一堆货物重量是多少？

输入：
- 输入第一行包含一个正整数 n ，表示货物的数量。
- 输入第二行包含 n 个正整数，表示 1~n 号货物的重量 w[i] 。
- 输入第三行有 n 个数，表示小美按顺序取出的货物的编号，也就是一个 1~n 的全排列。
输出：
- 输出包含 n 行，每行一个整数，表示每取出一件货物以后，对于重量和最大的一堆货物，其重量和为多少。

输入：
5
3 2 4 4 5
4 3 5 2 1
输出：
9
5
5
3
0
解释：
原本的状态是 {{3,2,4,4,5}} ，取出 4 号货物后，得到 {{3,2,4},{5}} ，第一堆货物的和是 9 ，然后取出 3 号货物得到 {{3,2}{5}} ，
此时第一堆和第二堆的和都是 5 ，以此类推。
 */
