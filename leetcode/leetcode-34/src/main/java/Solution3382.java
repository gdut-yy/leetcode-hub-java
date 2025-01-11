import java.util.Arrays;

public class Solution3382 {
    public long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;
        int[][] points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = xCoord[i];
            points[i][1] = yCoord[i];
        }
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(yCoord); // 离散化用

        long ans = -1;
        BIT tr = new BIT(n + 1);
        tr.add(Arrays.binarySearch(yCoord, points[0][1]) + 1, 1); // 离散化
        int[][] pre = new int[n][3];
        for (int i = 1; i < n; i++) {
            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];
            int y = Arrays.binarySearch(yCoord, y2); // 离散化
            tr.add(y + 1, 1);
            if (x1 != x2) { // 两点不在同一列
                continue;
            }
            int cur = tr.query(Arrays.binarySearch(yCoord, y1) + 1, y + 1);
            int[] p = pre[y];
            if (p[2] > 0 && p[2] + 2 == cur && p[1] == y1) {
                ans = Math.max(ans, (long) (x2 - p[0]) * (y2 - y1));
            }
            p[0] = x1;
            p[1] = y1;
            p[2] = cur;
        }
        return ans;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        // [l,r] 中的元素和
        int query(int l, int r) {
            return query(r) - query(l - 1);
        }
    }
}
/*
3382. 用点构造面积最大的矩形 II
https://leetcode.cn/problems/maximum-area-rectangle-with-point-constraints-ii/description/

第 427 场周赛 T4。

在无限平面上有 n 个点。给定两个整数数组 xCoord 和 yCoord，其中 (xCoord[i], yCoord[i]) 表示第 i 个点的坐标。
你的任务是找出满足以下条件的矩形可能的 最大 面积：
- 矩形的四个顶点必须是数组中的 四个 点。
- 矩形的内部或边界上 不能 包含任何其他点。
- 矩形的边与坐标轴 平行 。
返回可以获得的 最大面积 ，如果无法形成这样的矩形，则返回 -1。
提示：
1 <= xCoord.length == yCoord.length <= 2 * 10^5
0 <= xCoord[i], yCoord[i] <= 8 * 10^7
给定的所有点都是 唯一 的。

二维数点。
https://leetcode.cn/problems/maximum-area-rectangle-with-point-constraints-ii/solutions/3013907/chi-xian-xun-wen-chi-san-hua-shu-zhuang-gd604/
rating 2742 (clist.by)
 */