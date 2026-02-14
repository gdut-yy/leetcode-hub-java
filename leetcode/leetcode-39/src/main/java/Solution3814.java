import java.util.Arrays;
import java.util.Comparator;

public class Solution3814 {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machines = new int[n][2];
        for (int i = 0; i < n; i++) {
            machines[i][0] = costs[i];
            machines[i][1] = capacity[i];
        }
        Arrays.sort(machines, Comparator.comparingInt(a -> a[0]));
        int[] sortedCosts = new int[n];
        int[] caps = new int[n];
        for (int i = 0; i < n; i++) {
            sortedCosts[i] = machines[i][0];
            caps[i] = machines[i][1];
        }
        int[] prefMax = new int[n];
        prefMax[0] = caps[0];
        for (int i = 1; i < n; i++) {
            prefMax[i] = Math.max(prefMax[i - 1], caps[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sortedCosts[i] < budget) {
                ans = Math.max(ans, caps[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            int maxAllowed = budget - sortedCosts[i] - 1;
            if (maxAllowed < 0) continue;
            int pos = lastLessOrEqual(sortedCosts, maxAllowed);
            if (pos >= 0) {
                pos = Math.min(pos, i - 1);
                if (pos >= 0) {
                    int candidate = caps[i] + prefMax[pos];
                    if (candidate > ans) {
                        ans = candidate;
                    }
                }
            }
        }
        return ans;
    }

    private int lastLessOrEqual(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        int ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
/*
3814. 预算下的最大总容量
https://leetcode.cn/problems/maximum-capacity-within-budget/description/

第 485 场周赛 T2。

给你两个长度为 n 的整数数组 costs 和 capacity，其中 costs[i] 表示第 i 台机器的购买成本，capacity[i] 表示其性能容量。
同时，给定一个整数 budget。
你可以选择 最多两台不同的机器，使得所选机器的 总成本 严格小于 budget。
返回可以实现的 最大总容量。
提示：
1 <= n == costs.length == capacity.length <= 10^5
1 <= costs[i], capacity[i] <= 10^5
1 <= budget <= 2 * 10^5

二分答案。
https://chat.deepseek.com/a/chat/s/1f7421b3-7d82-4b2e-9da6-f89ba0a9d2f0
时间复杂度 O(nlogn)。
 */