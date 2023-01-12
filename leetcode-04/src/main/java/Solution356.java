import java.util.HashSet;
import java.util.Set;

public class Solution356 {
    private static final long E9 = (long) 1e9;

    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        Set<Long> set = new HashSet<>();
        for (int[] point : points) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            set.add(point[0] * E9 + point[1]);
        }

        // x = (minX + maxX) / 2 省去 / 2
        int ansX = minX + maxX;
        for (int[] point : points) {
            long find = (ansX - point[0]) * E9 + point[1];
            if (!set.contains(find)) {
                return false;
            }
        }
        return true;
    }
}
/*
$356. 直线镜像
https://leetcode.cn/problems/line-reflection/

在一个二维平面空间中，给你 n 个点的坐标。问，是否能找出一条平行于 y 轴的直线，让这些点关于这条直线成镜像排布？
注意：题目数据中可能有重复的点。
提示：
n == points.length
1 <= n <= 10^4
-10^8 <= points[i][j] <= 10^8

这条直线的 x 只能是 x 最小值 和 x 最大值的中点。
然后逐个判断即可。将二维压缩成一维存储。
时间复杂度 O(n)
 */