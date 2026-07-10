import java.util.Arrays;

public class Solution3961 {
    public long maxRatings(int[][] units) {
        int m = units.length;
        long totalA = 0;
        long totalB = 0;
        long totalATypeB = 0;
        long aMin = Long.MAX_VALUE;
        long minSinkCost = Long.MAX_VALUE;
        for (int[] row : units) {
            int n = row.length;
            Arrays.sort(row);
            int a = row[0];
            int b = n >= 2 ? row[1] : a;
            totalA += a;
            if (n >= 2) {
                totalB += b;
            } else {
                totalATypeB += a;
            }
            if (a < aMin) {
                aMin = a;
            }
            long cost = n >= 2 ? b : a;
            if (cost < minSinkCost) {
                minSinkCost = cost;
            }
        }
        long ans = totalA;
        long candidate = aMin + totalB + totalATypeB - minSinkCost;
        if (candidate > ans) {
            ans = candidate;
        }
        return ans;
    }
}
/*
3961. 设备评分的最大和
https://leetcode.cn/problems/maximize-sum-of-device-ratings/description/

第 506 场周赛 T3。

给你一个大小为 m × n 的二维整数数组 units，其中 units[i][j] 表示第 i 个设备中第 j 个单元的容量。每个设备 恰好 包含 n 个单元。
设备的 评分 是其所有单元中的 最小 容量。
你可以执行以下操作任意次（包括零次）：
- 选择一个以前 从未 被用作源的设备 i。
- 从设备 i 中 恰好 移除一个单元，并将其添加到 任意 其他设备中。
- 然后将设备 i 标记为已使用，这样它就不能再被选作源。
返回在进行任意次数的此类操作后，所有设备的评分之和的 最大 可能值。
注意：
- 设备可以接收来自多个设备的单元，无论它们是否已被选择过。
- 空设备的评分为 0。
提示：
1 <= m == units.length <= 10^5
1 <= n == units[i].length <= 10^5
m * n <= 2 * 10^5
1 <= units[i][j] <= 10^5

贪心。
时间复杂度 O(mn)。
 */