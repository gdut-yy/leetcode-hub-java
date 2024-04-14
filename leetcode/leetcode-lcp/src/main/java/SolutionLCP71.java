public class SolutionLCP71 {
    public int reservoir(String[] shape) {
        int M = shape.length;
        int N = shape[0].length();

        // 增加一层外边界
        int[][] up = new int[M + 2][N + 2];
        int[][] down = new int[M + 2][N + 2];
        int[][] left = new int[M + 2][N + 2];
        int[][] right = new int[M + 2][N + 2];

        // 共 4·M·N 个点 映射到 [0, id)
        int id = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                up[i][j] = id++;
                right[i][j] = id++;
                left[i][j] = id++;
                down[i][j] = id++;
            }
        }
        // 左右边界连超级汇点 id
        for (int i = 1; i <= M; i++) {
            right[i][0] = id;
            left[i][N + 1] = id;
        }
        // 下边界连超级汇点 id
        for (int j = 1; j <= N; j++) {
            up[M + 1][j] = id;
        }

        boolean[] mayWater = new boolean[id + 1];
        // 并查集
        DSU dsu = new DSU(id + 1);
        // 从下往上枚举
        for (int i = M; i >= 1; i--) {
            // 连通左右
            for (int j = 0; j <= N; j++) {
                dsu.union(right[i][j], left[i][j + 1]);
            }
            // 连通上下
            for (int j = 1; j <= N; j++) {
                dsu.union(down[i][j], up[i + 1][j]);
            }
            // 连通格子内部
            for (int j = 1; j <= N; j++) {
                char ch = shape[i - 1].charAt(j - 1);
                if (ch == '.') {
                    dsu.union(up[i][j], down[i][j]);
                    dsu.union(up[i][j], left[i][j]);
                    dsu.union(up[i][j], right[i][j]);
                } else if (ch == 'l') {
                    dsu.union(left[i][j], down[i][j]);
                    dsu.union(up[i][j], right[i][j]);
                } else {
                    dsu.union(left[i][j], up[i][j]);
                    dsu.union(down[i][j], right[i][j]);
                }
            }

            // 不连通表示可能有水
            for (int j = 1; j <= N; j++) {
                mayWater[up[i][j]] = (dsu.find(up[i][j]) != dsu.find(id));
                mayWater[down[i][j]] = (dsu.find(down[i][j]) != dsu.find(id));
                mayWater[left[i][j]] = (dsu.find(left[i][j]) != dsu.find(id));
                mayWater[right[i][j]] = (dsu.find(right[i][j]) != dsu.find(id));
            }
        }

        // 第一行连超级汇点
        for (int j = 1; j <= N; j++) {
            dsu.union(up[1][j], id);
        }

        // 统计数量
        int res = 0;
        for (int i = 0; i < id; i++) {
            // 不在闭合区域内可能有水
            if (mayWater[i] && dsu.find(i) == dsu.find(id)) {
                res++;
            }
        }
        return res / 2;
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        void union(int x, int y) {
            x= find(x);
            y= find(y);
            if (x == y) return;
            fa[x] = y;
        }
    }
}
/*
LCP 71. 集水器
https://leetcode.cn/problems/kskhHQ/

LCCUP'22 力扣杯秋季编程大赛战队赛 T6。

字符串数组 shape 描述了一个二维平面中的矩阵形式的集水器，shape[i][j] 表示集水器的第 i 行 j 列为：
- 'l'表示向左倾斜的隔板（即从左上到右下）；
- 'r'表示向右倾斜的隔板（即从左下到右上）；
- '.' 表示此位置没有隔板
已知当隔板构成存储容器可以存水，每个方格代表的蓄水量为 2。集水器初始浸泡在水中，除内部密闭空间外，所有位置均被水填满。
现将其从水中竖直向上取出，请返回集水器最终的蓄水量。
注意：
- 隔板具有良好的透气性，因此空气可以穿过隔板，但水无法穿过
提示：
1 <= shape.length <= 50
1 <= shape[i].length <= 50
shape[i][j] 仅为 'l'、'r' 或 '.'

并查集。
相似题目: 959. 由斜杠划分区域
https://leetcode.cn/problems/regions-cut-by-slashes/description/
 */