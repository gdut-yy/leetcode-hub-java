import java.util.HashMap;
import java.util.Map;

public class Solution2025 {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        Map<Integer, Integer> cntR = new HashMap<>();
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
            cntR.merge(sum[i - 1], 1, Integer::sum);
        }
        int ans = 0;
        int tot = sum[n - 1];
        if (tot % 2 == 0) ans = cntR.getOrDefault(tot / 2, 0); // 不修改

        Map<Integer, Integer> cntL = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int s = sum[i];
            int d = k - nums[i];
            if ((tot + d) % 2 == 0) {
                ans = Math.max(ans, cntL.getOrDefault((tot + d) / 2, 0)
                        + cntR.getOrDefault((tot - d) / 2, 0));
            }
            cntL.merge(s, 1, Integer::sum);
            cntR.merge(s, -1, Integer::sum);
        }
        return ans;
    }
}
/*
2025. 分割数组的最多方案数
https://leetcode.cn/problems/maximum-number-of-ways-to-partition-an-array/

第 62 场双周赛 T4。

给你一个下标从 0 开始且长度为 n 的整数数组 nums 。分割 数组 nums 的方案数定义为符合以下两个条件的 pivot 数目：
1 <= pivot < n
nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
同时给你一个整数 k 。你可以将 nums 中 一个 元素变为 k 或 不改变 数组。
请你返回在 至多 改变一个元素的前提下，最多 有多少种方法 分割 nums 使得上述两个条件都满足。
提示：
n == nums.length
2 <= n <= 10^5
-10^5 <= k, nums[i] <= 10^5

前缀和 + 双哈希表 + 枚举修改元素。
时间复杂度 O(n)。
树状数组会 TLE...
 */