import java.util.Arrays;

public class Solution3464 {
    public int maxDistance(int side, int[][] points, int k) {
        // 正方形边上的点，按照顺时针映射到一维数轴上
        long[] a = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (x == 0) {
                a[i] = y;
            } else if (y == side) {
                a[i] = side + x;
            } else if (x == side) {
                a[i] = side * 3L - y;
            } else {
                a[i] = side * 4L - x;
            }
        }
        Arrays.sort(a);

        int left = 1;
        int right = side + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!checkMid(a, side, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean checkMid(long[] a, int side, int k, int low) {
        next:
        for (long start : a) { // 枚举第一个点
            long end = start + side * 4L - low;
            long cur = start;
            for (int i = 0; i < k - 1; i++) { // 还需要找 k-1 个点
                int j = lowerBound(a, cur + low);
                if (j == a.length || a[j] > end) { // 不能离第一个点太近
                    continue next;
                }
                cur = a[j];
            }
            return true;
        }
        return false;
    }

    private int lowerBound(long[] a, long key) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= key) r = m;
            else l = m + 1;
        }
        return l;
    }
}
/*
3464. 正方形上的点之间的最大距离
https://leetcode.cn/problems/maximize-the-distance-between-points-on-a-square/description/

第 438 场周赛 T4。

给你一个整数 side，表示一个正方形的边长，正方形的四个角分别位于笛卡尔平面的 (0, 0) ，(0, side) ，(side, 0) 和 (side, side) 处。
同时给你一个 正整数 k 和一个二维整数数组 points，其中 points[i] = [xi, yi] 表示一个点在正方形边界上的坐标。
你需要从 points 中选择 k 个元素，使得任意两个点之间的 最小 曼哈顿距离 最大化 。
返回选定的 k 个点之间的 最小 曼哈顿距离的 最大 可能值。
两个点 (xi, yi) 和 (xj, yj) 之间的曼哈顿距离为 |xi - xj| + |yi - yj|。
提示：
1 <= side <= 10^9
4 <= points.length <= min(4 * side, 15 * 10^3)
points[i] == [xi, yi]
输入产生方式如下：
points[i] 位于正方形的边界上。
所有 points[i] 都 互不相同 。
4 <= k <= min(25, points.length)

二分答案 + 二分查找
https://leetcode.cn/problems/maximize-the-distance-between-points-on-a-square/solutions/3086167/zhuan-cheng-qie-bi-xue-fu-ju-chi-er-fen-nthy1/
rating 2790 (clist.by)
 */