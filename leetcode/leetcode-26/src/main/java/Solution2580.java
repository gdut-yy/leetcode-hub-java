import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2580 {
    private static final int MOD = (int) (1e9 + 7);

    public int countWays(int[][] ranges) {
        // 连通块个数 k，答案为 2^k
        int k = merge(ranges);
        return (int) quickPow(2, k);
    }

    private int merge(int[][] intervals) {
        // start 升序 end 降序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o2[1], o1[1]);
            }
            return Integer.compare(o1[0], o2[0]);
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> resList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (left <= interval[0] && right >= interval[1]) {
                continue;
            }
            if (right >= interval[0] && right <= interval[1]) {
                right = interval[1];
                continue;
            }
            if (right < interval[0]) {
                resList.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        resList.add(new int[]{left, right});
        return resList.size();
    }

    // 模下的 a^b
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
2580. 统计将重叠区间合并成组的方案数
https://leetcode.cn/problems/count-ways-to-group-overlapping-ranges/

第 99 场双周赛 T3。

给你一个二维整数数组 ranges ，其中 ranges[i] = [starti, endi] 表示 starti 到 endi 之间（包括二者）的所有整数都包含在第 i 个区间中。
你需要将 ranges 分成 两个 组（可以为空），满足：
- 每个区间只属于一个组。
- 两个有 交集 的区间必须在 同一个 组内。
如果两个区间有至少 一个 公共整数，那么这两个区间是 有交集 的。
- 比方说，区间 [1, 3] 和 [2, 5] 有交集，因为 2 和 3 在两个区间中都被包含。
请你返回将 ranges 划分成两个组的 总方案数 。由于答案可能很大，将它对 10^9 + 7 取余 后返回。
提示：
1 <= ranges.length <= 10^5
ranges[i].length == 2
0 <= starti <= endi <= 10^9

合并区间 + 快速幂
问题转换为有多少个连通块 k，答案为 2^k
相似题目: 56. 合并区间
https://leetcode.cn/problems/merge-intervals/
2550. 猴子碰撞的方法数
https://leetcode.cn/problems/count-collisions-of-monkeys-on-a-polygon/
 */