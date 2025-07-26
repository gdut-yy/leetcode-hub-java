import java.util.HashMap;
import java.util.Map;

public class Solution3623 {
    private static final int MOD = (int) (1e9 + 7);

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int[] p : points) {
            cnt.merge(p[1], 1, Integer::sum); // 统计每一行（水平线）有多少个点
        }

        long ans = 0, s = 0;
        for (int c : cnt.values()) {
            long k = (long) c * (c - 1) / 2;
            ans += s * k;
            s += k;
        }
        return (int) (ans % MOD);
    }
}
/*
3623. 统计梯形的数目 I
https://leetcode.cn/problems/count-number-of-trapezoids-i/description/

第 459 场周赛 T2。

给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点在笛卡尔平面上的坐标。
水平梯形 是一种凸四边形，具有 至少一对 水平边（即平行于 x 轴的边）。两条直线平行当且仅当它们的斜率相同。
返回可以从 points 中任意选择四个不同点组成的 水平梯形 数量。
由于答案可能非常大，请返回结果对 10^9 + 7 取余数后的值。
提示：
4 <= points.length <= 10^5
–10^8 <= xi, yi <= 10^8
所有点两两不同。

枚举右，维护左
时间复杂度 O(n)。
 */