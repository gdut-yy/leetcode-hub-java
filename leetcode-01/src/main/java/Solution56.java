import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return -(o1[1] - o2[1]);
            }
            return o1[0] - o2[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];
        List<int[]> resList = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            // case1:
            // left-------------------------right
            // -----interval[0]-interval[1]
            if (left <= interval[0] && right >= interval[1]) {
                // 无需处理 忽略即可
                continue;
            }
            // case2:
            // left-------------right
            // -----interval[0]-------interval[1]
            if (right >= interval[0] && right <= interval[1]) {
                // 合并处理
                right = interval[1];
                continue;
            }
            // case3:
            // left-right
            // -----------interval[0]-interval[1]
            if (right < interval[0]) {
                // left right 已再无合并可能，添加进 list
                resList.add(new int[]{left, right});
                left = interval[0];
                right = interval[1];
            }
        }
        // 添加最后一组 list
        resList.add(new int[]{left, right});

        int len = resList.size();
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
}
/*
56. 合并区间
https://leetcode-cn.com/problems/merge-intervals/

排序后分三种情况合并区间即可。
 */