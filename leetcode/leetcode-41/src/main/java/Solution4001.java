import java.util.ArrayList;
import java.util.List;

public class Solution4001 {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = series1.length, m = series2.length;
        int i = 0, j = 0;

        while (i < n && j < m) {
            int t1 = series1[i][0], t2 = series2[j][0];
            int sum = series1[i][1] + series2[j][1];
            if (t1 < t2) {
                ans.add(List.of(t1, sum));
                i++;
            } else if (t1 > t2) {
                ans.add(List.of(t2, sum));
                j++;
            } else { // 相等
                ans.add(List.of(t1, sum));
                i++;
                j++;
            }
        }

        while (i < n) {
            ans.add(List.of(series1[i][0], series1[i][1]));
            i++;
        }
        while (j < m) {
            ans.add(List.of(series2[j][0], series2[j][1]));
            j++;
        }
        return ans;
    }
}
/*
4001. 聚合两个时间序列
https://leetcode.cn/problems/aggregate-two-time-series/description/

第 512 场周赛 T2。

给你两个二维整数数组 series1 和 series2。
两个序列中的每个元素都表示为 [timestamp, value]，其中：
- timestamp 是表示时间的整数。
- value 是表示该时间点对应值的整数。
每个数组都按照 timestamp 的 严格递增 顺序排列。
若某个序列中某个时间戳 缺失 ，且该序列中存在更晚的时间戳，则将该缺失时间戳的值设为下一个更晚时间戳对应的值。否则，该时间点的值视为 0。
聚合序列 通过以下方式构造：对于两个序列中出现过的每个时间戳，将两个序列在该时间戳对应的值相加。
返回聚合后的序列，格式为二维整数数组 [timestamp, summedValue]，并按照 timestamp 严格递增 排序。
如果一个数组中的每个元素都严格大于前一个元素，则称该数组为 严格递增 。
提示：
1 <= series1.length, series2.length <= 10^5
series1[i].length == series2[i].length == 2
1 <= series1[i][0], series2[i][0] <= 10^9
1 <= series1[i][1], series2[i][1] <= 10^9
每个序列都按照 timestamp 严格递增排序。

双指针，合并两个有序列表。
时间复杂度 O(n + m)。
 */