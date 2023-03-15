import java.util.Map;
import java.util.TreeMap;

public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0];
            treeMap.put(start, i);
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            int end = intervals[i][1];
            Map.Entry<Integer, Integer> ceilingEntry = treeMap.ceilingEntry(end);
            if (ceilingEntry != null) {
                res[i] = ceilingEntry.getValue();
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
/*
436. 寻找右区间
https://leetcode.cn/problems/find-right-interval/

给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
提示：
1 <= intervals.length <= 2 * 10^4
intervals[i].length == 2
-10^6 <= starti <= endi <= 10^6
每个间隔的起点都 不相同

利用 TreeMap#ceilingEntry() 找出下一个右区间。
时间复杂度 O(nlogn)
 */