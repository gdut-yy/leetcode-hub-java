import java.util.HashMap;
import java.util.Map;

public class Solution3625 {
    public int countTrapezoids(int[][] points) {
        Map<Double, Map<Double, Integer>> cnt = new HashMap<>(); // 斜率 -> 截距 -> 个数
        Map<Integer, Map<Double, Integer>> cnt2 = new HashMap<>(); // 中点 -> 斜率 -> 个数

        int n = points.length;
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            for (int j = 0; j < i; j++) {
                int x2 = points[j][0], y2 = points[j][1];
                int dy = y - y2;
                int dx = x - x2;
                double k = dx != 0 ? 1.0 * dy / dx : Double.MAX_VALUE;
                double b = dx != 0 ? 1.0 * (y * dx - x * dy) / dx : x;

                // 归一化 -0.0 为 0.0
                if (k == -0.0) {
                    k = 0.0;
                }
                if (b == -0.0) {
                    b = 0.0;
                }

                // 按照斜率和截距分组 cnt[k][b]++
                cnt.computeIfAbsent(k, e -> new HashMap<>()).merge(b, 1, Integer::sum);

                int mid = (x + x2 + 2000) << 16 | (y + y2 + 2000); // 把二维坐标压缩成一个 int
                // 按照中点和斜率分组 cnt2[mid][k]++
                cnt2.computeIfAbsent(mid, e -> new HashMap<>()).merge(k, 1, Integer::sum);
            }
        }

        int ans = 0;
        for (Map<Double, Integer> m : cnt.values()) {
            int s = 0;
            for (int c : m.values()) {
                ans += s * c;
                s += c;
            }
        }

        for (Map<Double, Integer> m : cnt2.values()) {
            int s = 0;
            for (int c : m.values()) {
                ans -= s * c; // 平行四边形会统计两次，减去多统计的一次
                s += c;
            }
        }

        return ans;
    }
}
/*
3625. 统计梯形的数目 II
https://leetcode.cn/problems/count-number-of-trapezoids-ii/description/

第 459 场周赛 T4。

给你一个二维整数数组 points，其中 points[i] = [xi, yi] 表示第 i 个点在笛卡尔平面上的坐标。
返回可以从 points 中任意选择四个不同点组成的梯形的数量。
梯形 是一种凸四边形，具有 至少一对 平行边。两条直线平行当且仅当它们的斜率相同。
提示：
4 <= points.length <= 500
–1000 <= xi, yi <= 1000
所有点两两不同。

统计直线 + 去掉重复统计的平行四边形 https://leetcode.cn/problems/count-number-of-trapezoids-ii/solutions/3728529/tong-ji-zhi-xian-qu-diao-zhong-fu-tong-j-a3f9/
rating 2681 (clist.by)
 */