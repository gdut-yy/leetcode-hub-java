import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SolutionP3323 {
    public int minConnectedGroups(int[][] intervals, int k) {
        // 合并区间
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] p : intervals) {
            int l = p[0], r = p[1];
            if (!merged.isEmpty() && l <= merged.getLast()[1]) {
                merged.getLast()[1] = Math.max(merged.getLast()[1], r);
            } else {
                merged.add(new int[]{l, r});
            }
        }
        // 双指针
        int sz = merged.size();
        int best = 0;
        int l = 0, r = 0;
        while (r < sz) {
            while (merged.get(r)[0] - merged.get(l)[1] > k) {
                l++;
            }
            best = Math.max(best, r - l);
            r++;
        }
        return sz - best;
    }
}
/*
$3323. 通过插入区间最小化连通组
https://leetcode.cn/problems/minimize-connected-groups-by-inserting-interval/description/

给定一个 2 维数组 intervals，其中 intervals[i] = [starti, endi] 表示区间 i 的开头和结尾。另外还给定一个整数 k。
你必须向数组 恰好添加一个 新的区间 [startnew, endnew] 使得：
- 新区间的长度，endnew - startnew 最多为 k。
- 在添加之后，intervals 中 连通组 的数量 最少。
区间的 连通组 是一起覆盖了从最小点到最大点的连续范围，中间没有间隙的区间的最大集合。下面是一些例子：
- 区间组 [[1, 2], [2, 5], [3, 3]] 是连通的，因为它们一起覆盖了 1 到 5 的范围，中间没有任何间隔。
- 然而，区间组 [[1, 2], [3, 4]] 不是连通的，因为 (2, 3) 段没有被覆盖。
返回在数组 恰好添加一个 新区间后，连通组的 最小 数量。
提示：
1 <= intervals.length <= 10^5
intervals[i] == [starti, endi]
1 <= starti <= endi <= 10^9
1 <= k <= 10^9

合并区间 + 双指针。
时间复杂度 O(nlogn)。
 */