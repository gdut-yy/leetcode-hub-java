import java.util.HashMap;
import java.util.Map;

public class Solution3588 {
    public long maxArea(int[][] coords) {
        return Math.max(getAns(coords, 0), getAns(coords, 1));
    }

    // xy_type:0=x 1=y
    private long getAns(int[][] coords, int xy_type) {
        long minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        Map<Integer, Integer> minXForY = new HashMap<>();
        Map<Integer, Integer> maxXForY = new HashMap<>();
        for (int[] p : coords) {
            int x = p[xy_type], y = p[1 - xy_type];
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
            minXForY.merge(y, x, Math::min);
            maxXForY.merge(y, x, Math::max);
        }
        long ans = -1;
        // 处理平行于x轴的边的情况
        for (Map.Entry<Integer, Integer> entry : minXForY.entrySet()) {
            int y = entry.getKey();
            int minXInY = entry.getValue();
            int maxXInY = maxXForY.get(y);
            long base = maxXInY - minXInY;
            if (base <= 0) continue; // 底边长度无效
            long height = Math.max(y - minY, maxY - y);
            if (height <= 0) continue; // 高无效
            ans = Math.max(ans, base * height);
        }
        return ans;
    }
}
/*
3588. 找到最大三角形面积
https://leetcode.cn/problems/find-maximum-area-of-a-triangle/description/

第 159 场双周赛 T2。

给你一个二维数组 coords，大小为 n x 2，表示一个无限笛卡尔平面上 n 个点的坐标。
找出一个 最大 三角形的 两倍 面积，其中三角形的三个顶点来自 coords 中的任意三个点，并且该三角形至少有一条边与 x 轴或 y 轴平行。严格地说，如果该三角形的最大面积为 A，则返回 2 * A。
如果不存在这样的三角形，返回 -1。
注意，三角形的面积 不能 为零。
提示：
1 <= n == coords.length <= 10^5
1 <= coords[i][0], coords[i][1] <= 10^6
所有 coords[i] 都是 唯一 的。

枚举平行于 x 轴情况：底边长度 为 maxXInY - minXInY，高度为 max(y - minY, maxY - y)。
平行于 y 轴情况同理。
时间复杂度 O(n)。
 */