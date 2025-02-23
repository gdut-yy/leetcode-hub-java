import java.util.List;

public class Solution624 {
    public int maxDistance(List<List<Integer>> arrays) {
        int inf = (int) 1e9;
        int ans = 0;
        int pre_mn = inf, pre_mx = -inf;
        for (List<Integer> arr : arrays) {
            int mn = arr.getFirst();
            int mx = arr.getLast();
            ans = Math.max(ans, Math.max(mx - pre_mn, pre_mx - mn));
            pre_mn = Math.min(pre_mn, mn);
            pre_mx = Math.max(pre_mx, mx);
        }
        return ans;
    }
}
/*
624. 数组列表中的最大距离
https://leetcode.cn/problems/maximum-distance-in-arrays/

给定 m 个数组，每个数组都已经按照升序排好序了。
现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。
返回最大距离。
提示：
m == arrays.length
2 <= m <= 10^5
1 <= arrays[i].length <= 500
-10^4 <= arrays[i][j] <= 10^4
arrays[i] 以 升序 排序。
所有数组中最多有 10^5 个整数。

枚举右，维护左
 */