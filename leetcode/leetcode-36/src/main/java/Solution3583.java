import java.util.HashMap;
import java.util.Map;

public class Solution3583 {
    private static final int MOD = (int) (1e9 + 7);

    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int[] lcnt = new int[n];
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lcnt[i] = cnt.getOrDefault(nums[i] * 2, 0);
            cnt.merge(nums[i], 1, Integer::sum);
        }

        int[] rcnt = new int[n];
        cnt.clear();
        for (int i = n - 1; i >= 0; i--) {
            rcnt[i] = cnt.getOrDefault(nums[i] * 2, 0);
            cnt.merge(nums[i], 1, Integer::sum);
        }

        long ans = 0;
        for (int i = 1; i + 1 < n; i++) {
            ans = (ans + (long) lcnt[i] * rcnt[i]) % MOD;
        }
        return (int) ans;
    }
}
/*
3583. 统计特殊三元组
https://leetcode.cn/problems/count-special-triplets/description/

第 454 场周赛 T2。

给你一个整数数组 nums。
特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)：
- 0 <= i < j < k < n，其中 n = nums.length
- nums[i] == nums[j] * 2
- nums[k] == nums[j] * 2
返回数组中 特殊三元组 的总数。
由于答案可能非常大，请返回结果对 10^9 + 7 取余数后的值。
提示：
3 <= n == nums.length <= 10^5
0 <= nums[i] <= 10^5

前后缀分解 + 枚举中间。
时间复杂度 O(n)。
 */