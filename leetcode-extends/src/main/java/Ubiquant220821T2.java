public class Ubiquant220821T2 {
    public int lakeCount(String[] field) {
        int M = field.length;
        int N = field[0].length();

        char[][] chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = field[i].toCharArray();
        }

        int cntW = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (chars[i][j] == 'W') {
                    cntW++;
                }
            }
        }

        DSU dsu = new DSU(M * N);
        dsu.sz = cntW;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (chars[i][j] == 'W') {
                    int p = i * N + j;
                    // up
                    if (i - 1 >= 0 && chars[i - 1][j] == 'W') {
                        dsu.union(p, p - N);
                    }
                    // down
                    if (i + 1 < M && chars[i + 1][j] == 'W') {
                        dsu.union(p, p + N);
                    }
                    // left
                    if (j - 1 >= 0 && chars[i][j - 1] == 'W') {
                        dsu.union(p, p - 1);
                    }
                    // right
                    if (j + 1 < N && chars[i][j + 1] == 'W') {
                        dsu.union(p, p + 1);
                    }

                    // 左上
                    if (i - 1 >= 0 && j - 1 >= 0 && chars[i - 1][j - 1] == 'W') {
                        dsu.union(p, p - N - 1);
                    }
                    // 右上
                    if (i - 1 >= 0 && j + 1 < N && chars[i - 1][j + 1] == 'W') {
                        dsu.union(p, p - N + 1);
                    }
                    // 左下
                    if (i + 1 < M && j - 1 >= 0 && chars[i + 1][j - 1] == 'W') {
                        dsu.union(p, p + N - 1);
                    }
                    // 右下
                    if (i + 1 < M && j + 1 < N && chars[i + 1][j + 1] == 'W') {
                        dsu.union(p, p + N + 1);
                    }
                }
            }
        }
        return dsu.sz;
    }

    private static class DSU {
        // 父节点数组/祖先数组
        int[] fa;
        int sz;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
            sz--;
        }
    }
}
/*
九坤-02. 池塘计数
https://leetcode.cn/contest/ubiquant2022/problems/3PHTGp/

最近的降雨，使田地中的一些地方出现了积水，field[i][j] 表示田地第 i 行 j 列的位置有：
- 若为 W, 表示该位置为积水；
- 若为 ., 表示该位置为旱地。
已知一些相邻的积水形成了若干个池塘，若以 W 为中心的八个方向相邻积水视为同一片池塘。
请返回田地中池塘的数量。

示例 1：
输入: field = [".....W",".W..W.","....W.",".W....","W.WWW.",".W...."]
输出：3
解释：如下图所示，共有 3 个池塘：

示例 2：
输入: field = ["W....W",".W..W.","..W.W.","W..W..","W.W...",".W...."]
输出：1
解释：如下图所示，共有 1 个池塘：

提示：
1 <= field.length, field[i].length <= 100
field 中仅包含 W 和 .

并查集求联通分量
相似题目: 200. 岛屿数量
https://leetcode.cn/problems/number-of-islands/
 */