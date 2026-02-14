import java.util.ArrayList;
import java.util.List;

public class Solution3809 {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        List<int[]> ans = new ArrayList<>();
        int mx = 0;
        for (int[] t : towers) {
            int x = t[0], y = t[1], q = t[2];
            int manhattan = Math.abs(x - center[0]) + Math.abs(y - center[1]);
            if (manhattan <= radius) {
                if (q > mx) {
                    mx = q;
                    ans.clear();
                    ans.add(new int[]{x, y});
                } else if (q == mx) {
                    ans.add(new int[]{x, y});
                }
            }
        }
        if (ans.isEmpty()) {
            return new int[]{-1, -1};
        }
        ans.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return ans.getFirst();
    }
}
/*
3809. 最好可到达的塔
https://leetcode.cn/problems/best-reachable-tower/description/

第 174 场双周赛 T1。

给你一个二维整数数组 towers，其中 towers[i] = [xi, yi, qi] 表示第 i 座塔的坐标 (xi, yi) 和质量因子 qi。
另外给你一个整数数组 center = [cx, cy] 表示你的位置，以及一个整数 radius。
如果一座塔与 center 之间的 曼哈顿距离小于或等于 radius，则称该塔是 可到达的。
在所有可到达的塔中：
- 返回质量因子 最大 的塔的坐标。
- 如果存在并列的塔，返回坐标 字典序最小 的塔。如果没有塔是可到达的，返回 [-1, -1]。
两点 (xi, yi) 和 (xj, yj) 之间的 曼哈顿距离 为 |xi - xj| + |yi - yj|。
坐标 [xi, yi] 字典序小于 [xj, yj] 是指：xi < xj，或者 xi == xj 且 yi < yj。
|x| 表示 x 的 绝对值。
提示：
1 <= towers.length <= 10^5
towers[i] = [xi, yi, qi]
center = [cx, cy]
0 <= xi, yi, qi, cx, cy <= 10^5
0 <= radius <= 10^5

模拟。自定义排序。
时间复杂度 O(nlogn)。
 */