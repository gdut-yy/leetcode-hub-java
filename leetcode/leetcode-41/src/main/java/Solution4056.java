import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4056 {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long ans = 0;
        for (int[] interval : intervals) {
            int start = interval[0];
            while (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }
            ans += pq.size();
            pq.offer(interval[1]);
        }
        return Math.toIntExact(ans);
    }
}
/*
4056. 统计相交区间对 I
https://leetcode.cn/problems/number-of-intersecting-interval-pairs-i/description/

第 520 场周赛 T1。

给你一个包含 n 个元素的二维整数数组 intervals，其中 intervals[i] = [starti, endi] 表示从 starti 到 endi 的 闭区间 。
返回满足 0 <= i < j < n，且 intervals[i] 与 intervals[j] 相交 的下标对 (i, j) 的数量。
如果两个区间至少有一个公共点，则称它们 相交。仅共享一个端点的情况也视为相交。
示例 1：
输入： intervals = [[1,2],[2,3],[3,4]]
输出： 2
示例 2：
输入： intervals = [[1,5],[2,4],[3,6]]
输出： 3
示例 3：
输入： intervals = [[1,2],[3,4],[5,6]]
输出： 0
提示：
2 <= intervals.length <= 100
intervals[i] == [starti, endi]
0 <= starti <= endi <= 100

优先队列。
时间复杂度 O(nlogn)。
 */