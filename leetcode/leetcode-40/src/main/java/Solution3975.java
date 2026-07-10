import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution3975 {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merge = new ArrayList<>();
        for (int[] p : occupiedIntervals) {
            int l = p[0], r = p[1];
            if (!merge.isEmpty() && l <= merge.get(merge.size() - 1)[1] + 1) {
                merge.get(merge.size() - 1)[1] = Math.max(merge.get(merge.size() - 1)[1], r);
            } else {
                merge.add(new int[]{l, r});
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int[] p : merge) {
            int l = p[0], r = p[1];
            if (freeEnd < l || freeStart > r) {
                ans.add(List.of(l, r));
            } else if (freeStart <= l && r <= freeEnd) {
                continue;
            } else if (freeStart <= l && freeEnd < r) {
                ans.add(List.of(freeEnd + 1, r));
            } else if (l < freeStart && r <= freeEnd) {
                ans.add(List.of(l, freeStart - 1));
            } else {
                ans.add(List.of(l, freeStart - 1));
                ans.add(List.of(freeEnd + 1, r));
            }
        }
        return ans;
    }
}
/*
3975. 筛选忙碌区间
https://leetcode.cn/problems/filter-occupied-intervals/description/

第 508 场周赛 T2。

给你一个二维整数数组 occupiedIntervals，其中 occupiedIntervals[i] = [starti, endi] 表示你处于忙碌状态的一个时间区间。每个区间从 starti 开始，到 endi 结束，并且 包含 两个端点。这些区间可能会 重叠。
此外，另给你两个整数 freeStart 和 freeEnd，它们定义了一个你空闲的时间区间。该空闲区间从 freeStart 开始，到 freeEnd 结束，并且 包含 两个端点。
你的任务是先将所有重叠或相接的忙碌区间 合并 ，然后从合并后的忙碌区间中 移除 空闲区间内的 所有 整数点。
如果第二个区间正好从第一个区间结束后的下一个位置开始，则称这两个区间相接。例如，[1, 1] 和 [2, 2] 相接，应合并为 [1, 2]。
返回按 升序 排列的 剩余 忙碌区间。返回的区间必须 互不重叠 ，并且区间数量应尽可能 最少 。如果没有剩余的忙碌整数点，则返回 空列表 。
提示：
1 <= occupiedIntervals.length <= 5 * 10^4
occupiedIntervals[i].length == 2
1 <= starti <= endi <= 10^9
1 <= freeStart <= freeEnd <= 10^9

合并区间。
时间复杂度 O(nlogn)。
 */