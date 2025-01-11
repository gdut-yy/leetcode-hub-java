import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3380 {
    // T2 939
    public int maxRectangleArea(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o1[1], o2[1]);
        });

        int ans = -1;
        for (int mask = 0; mask < 1 << n; mask++) {
            if (Integer.bitCount(mask) == 4) {
                List<Integer> ids = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((mask >> i & 1) == 1) {
                        ids.add(i);
                    }
                }
                ans = Math.max(ans, getRectangleArea(points, ids));
            }
        }
        return ans;
    }

    private int getRectangleArea(int[][] points, List<Integer> ids) {
        int[] p1 = points[ids.get(0)];
        int[] p2 = points[ids.get(1)];
        int[] p3 = points[ids.get(2)];
        int[] p4 = points[ids.get(3)];
        // 矩形的边与坐标轴 平行
        if (p1[1] != p2[1] || p3[1] != p4[1] || p1[0] != p3[0] || p2[0] != p4[0]) return -1;
        if (p2[0] - p1[0] != p4[0] - p3[0]) return -1;
        if (p3[1] - p1[1] != p4[1] - p2[1]) return -1;
        // 矩形的内部或边界上 不能 包含任何其他点
        for (int i = 0; i < points.length; i++) {
            if (ids.contains(i)) continue;
            int x = points[i][0], y = points[i][1];
            if (p1[0] <= x && x <= p4[0] && p1[1] <= y && y <= p4[1]) {
                return -1;
            }
        }
        return (p2[0] - p1[0]) * (p3[1] - p1[1]);
    }
}
/*
3380. 用点构造面积最大的矩形 I
https://leetcode.cn/problems/maximum-area-rectangle-with-point-constraints-i/description/

第 427 场周赛 T2。

给你一个数组 points，其中 points[i] = [xi, yi] 表示无限平面上一点的坐标。
你的任务是找出满足以下条件的矩形可能的 最大 面积：
- 矩形的四个顶点必须是数组中的 四个 点。
- 矩形的内部或边界上 不能 包含任何其他点。
- 矩形的边与坐标轴 平行 。
返回可以获得的 最大面积 ，如果无法形成这样的矩形，则返回 -1。
提示：
1 <= points.length <= 10
points[i].length == 2
0 <= xi, yi <= 100
给定的所有点都是 唯一 的。

可以四层循环枚举 时间复杂度 O(n^4)。 约10000
二进制枚举 时间复杂度是 O(n*2^n)。约10240
 */