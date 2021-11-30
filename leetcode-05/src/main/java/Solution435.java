import java.util.Arrays;

public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        int cnt = 1;
        int right = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= right) {
                right = intervals[i][1];
                cnt++;
            }
        }
        return len - cnt;
    }
}
/*
435. 无重叠区间
https://leetcode-cn.com/problems/non-overlapping-intervals/

给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

贪心。按右区间升序排序，找到最小的右区间即为 第 1 个区间，余下来的区间，只要满足左区间大于当前右区间，则更新右区间。
时间复杂度 O(nlogn)
 */